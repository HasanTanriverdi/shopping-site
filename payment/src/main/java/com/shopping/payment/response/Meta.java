package com.shopping.payment.response;

public class Meta {

    public int errorCode;
    public String errorMessage;

    public Meta() {
    }

    public Meta(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
