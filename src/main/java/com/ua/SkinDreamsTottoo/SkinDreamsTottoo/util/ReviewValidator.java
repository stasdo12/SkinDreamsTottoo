package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Review;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ReviewValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Review.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "authorName", "NotEmpty");
        Review review = (Review) target;
        String authorName = review.getAuthorName();
        if (authorName.length() < 2 || authorName.length() > 30) {
            errors.rejectValue("authorName", "Size", "Name should be between 2 and 30 characters");
        }
        if (!authorName.matches("[A-Za-zА-Яа-яЁё]+")) {
            errors.rejectValue("authorName", "Pattern", "Name should not contain numbers");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rating", "NotEmpty");
        int rating = review.getRating();
        if (rating < 1 || rating > 5) {
            errors.rejectValue("rating", "Range.review.rating");
        }
    }

}

