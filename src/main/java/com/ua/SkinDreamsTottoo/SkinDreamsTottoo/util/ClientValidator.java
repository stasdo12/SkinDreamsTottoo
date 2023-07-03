package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.util;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class ClientValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClazz) {
        return Client.class.equals(aClazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty", "Name should not be empty");

        Client client = (Client) target;
        String name = client.getName();
        if (name.length() < 2 || name.length() > 30) {
            errors.rejectValue("name", "Size", "Name should be between 2 and 30 characters");
        }
        if (!name.matches("[A-Za-zА-Яа-яЁё]+")) {
            errors.rejectValue("name", "Pattern", "Name should not contain numbers");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty", "Phone should not be empty");
        String phone = client.getPhone();
        if (!phone.matches("\\d{10}")) {
            errors.rejectValue("phone", "Pattern", "Phone should be a 10-digit number");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "question", "NotEmpty",
                "Question should not be empty");


    }
}
