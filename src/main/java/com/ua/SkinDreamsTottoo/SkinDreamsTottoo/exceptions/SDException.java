package com.ua.SkinDreamsTottoo.SkinDreamsTottoo.exceptions;

public class SDException extends RuntimeException{

    public SDException(String massage){
        super(massage);
    }


    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
