package com.shopping.stock.exception;

import com.shopping.stock.response.Meta;
import com.shopping.stock.response.ProductResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHanddler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> handlerExceptions(ProductPriceException exception, WebRequest webRequest){
        ProductResponse response = new ProductResponse();
        Meta meta= new Meta();
        meta.errorCode= 30005;
        meta.errorMessage= "product price cannot be 0";
        response.meta = meta;
        ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
