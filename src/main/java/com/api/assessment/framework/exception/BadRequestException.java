package com.api.assessment.framework.exception;

/** @author ajrozo */
public class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -5372939932064008617L;

    public BadRequestException(String detail) {
        super(detail);
    }

}
