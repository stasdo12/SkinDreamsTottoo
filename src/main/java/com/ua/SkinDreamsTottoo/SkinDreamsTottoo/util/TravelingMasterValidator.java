package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.TravelingMaster;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TravelingMasterValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return TravelingMaster.class.equals(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", "Name should not be empty");
        TravelingMaster travelingMaster = (TravelingMaster) target;
        String name = travelingMaster.getName();
        if (name.length() < 2 || name.length() > 30) {
            errors.rejectValue("name", "Size", "Name should be between 2 and 30 characters");
        }
        if (!name.matches("[A-Za-zА-Яа-яЁё]+")) {
            errors.rejectValue("name", "Pattern", "Name should not contain numbers");
        }

    }
}
