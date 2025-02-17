package com.eval.jvs.exception;


public class ModelNotFoundException extends RuntimeException {
    
    public ModelNotFoundException(String message){
        super(message);
    }
}
