package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.controllers;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Master;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions.SDException;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.MasterService;
import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/otzyvy")
public class ReviewController {


    private final ReviewService reviewService;

    private final MasterService masterService;


    @Autowired
    public ReviewController(ReviewService reviewService, MasterService masterService) {
        this.reviewService = reviewService;
        this.masterService = masterService;
    }


    @GetMapping
    public String reviewPage(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "5") int size,
            Model model) {
         Pageable pageable = PageRequest.of(page, size);
        model.addAttribute("reviews", reviewService.findAllReview(pageable));
        model.addAttribute("currentPage", page);
        model.addAttribute("pageSize", size);
        model.addAttribute("masters", masterService.findAllMasters());
        return "review/index";
    }


    @PostMapping("/add-review")
    public String addReview(@ModelAttribute Review review, @RequestParam("masterName") String masterName,
                            RedirectAttributes redirectAttributes){
        Master selectedMaster = masterService.findMasterByName(masterName);
        review.setMaster(selectedMaster);
        reviewService.saveReview(review);
        redirectAttributes.addFlashAttribute("successMessage", "Дякую, ваш відгук було відправлено.");
        return "redirect:/otzyvy#success";
    }

    @ExceptionHandler(SDException.class)
    public String handleClientException(SDException ex, Model model){
        model.addAttribute("errorMassage", ex.getMessage());
        return "templates/error/error-page";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "templates/error/error-page";
    }

}
