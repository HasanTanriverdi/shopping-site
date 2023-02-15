package com.akademi.basket.dto;


import java.io.Serializable;
import java.util.List;

public class BasketDto implements Serializable {
    public List<BasketProductDto> basketProductList;
    private int basketId;
    private double amount;
    private int status;
    private int userId;
}
