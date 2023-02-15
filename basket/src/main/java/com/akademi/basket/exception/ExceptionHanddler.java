package com.akademi.basket.exception;

import com.akademi.basket.response.BasketProductResponse;
import com.akademi.basket.response.Meta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHanddler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NumberErrorException.class)
    public ResponseEntity<Object> handlerNumberFormatException(NumberErrorException exception, WebRequest webRequest) {
        BasketProductResponse response = new BasketProductResponse();
        Meta meta = new Meta();
        meta.errorCode = 30005;
        meta.errorMessage = "basketproduct count cannot be double";
        response.meta = meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
