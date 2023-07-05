package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.EmailSenderService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.MasterService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ReviewService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util.ReviewValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/otzyvy")
public class ReviewController {

    private final ReviewService reviewService;
    private final MasterService masterService;
    private final EmailSenderService emailSenderService;
    private final ReviewValidator reviewValidator;

    @Autowired
    public ReviewController(ReviewService reviewService, MasterService masterService, EmailSenderService emailSenderService, ReviewValidator reviewValidator) {
        this.reviewService = reviewService;
        this.masterService = masterService;
        this.emailSenderService = emailSenderService;
        this.reviewValidator = reviewValidator;
    }

    @GetMapping
    public String reviewPage(@RequestParam(required = false, defaultValue = "0") int page,
                             @RequestParam(required = false, defaultValue = "5") int size,
                             Model model) {
        Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("review", new Review());
        model.addAttribute("reviews", reviewService.findAllReview(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("masters", masterService.findAllMasters());
        return "review/index";
    }

    @PostMapping("/add-review")
    public String addReview(@Valid @ModelAttribute("review") Review review,
                            BindingResult bindingResult,
                            @RequestParam("masterName") String masterName,
                            RedirectAttributes redirectAttributes,
                            Model model) {
        reviewValidator.validate(review, bindingResult);
        if (bindingResult.hasErrors()) {
            return handleReviewFormErrors(model);
        }
        Master selectedMaster = masterService.findMasterByName(masterName);
        review.setMaster(selectedMaster);
        review.setRegistrationTime(LocalDateTime.now());
        reviewService.saveReview(review);
        sendReviewEmail(review);
        redirectAttributes.addFlashAttribute("successMessage", "Дякую, ваш відгук було відправлено.");
        return "redirect:/otzyvy#success";
    }

    private String handleReviewFormErrors(Model model) {
        Pageable pageable = PageRequest.of(0, 10);
        model.addAttribute("reviews", reviewService.findAllReview(pageable));
        model.addAttribute("masters", masterService.findAllMasters());
        return "review/index";
    }

    private void sendReviewEmail(Review review) {
        String toEmail = "stanislavdonetc@gmail.com";
        String emailSubject = "Review";
        String emailBody = "Author review names: " +
                review.getAuthorName() +
                "\n" + "Author review text: " +
                review.getText() +
                "\n" + "Author review rating : " +
                review.getRating() +
                "\n" + "Master : "
                + review.getMaster().getName();
        emailSenderService.sendEmail(toEmail, emailSubject, emailBody);
    }

    @ExceptionHandler(SDException.class)
    public String handleClientException(SDException ex, Model model) {
        model.addAttribute("errorMassage", ex.getMessage());
        return "templates/error/error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "templates/error/error-page";
    }
}
