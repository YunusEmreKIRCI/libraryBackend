package com.turkcell.spring.intro.core.utils.exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message){
        super(message);
    }

}
