package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.validatior;

import com.ua.SkinDreamsTottoo.SkinDreamsTottoo.entity.Client;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ClientValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClazz) {
        return Client.class.equals(aClazz);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Client client = (Client) o;
        if (client.getName() == null){
        errors.rejectValue("name", "", "This name incorrect" );}

    }
}
