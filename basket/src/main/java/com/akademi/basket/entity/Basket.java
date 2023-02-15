package com.akademi.basket.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketId;
    private double amount;
    private int status;
    private int userId;

    @OneToMany(mappedBy = "basket")
    @JsonManagedReference
    private List<BasketProduct> basketProductList;

    public Basket() {
    }

    public Basket(int basketId, double amount, int status, int userId, List<BasketProduct> basketProductList) {
        this.basketId = basketId;
        this.amount = amount;
        this.status = status;
        this.userId = userId;
        this.basketProductList = basketProductList;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<BasketProduct> getBasketProductList() {
        return basketProductList;
    }

    public void setBasketProductList(List<BasketProduct> basketProductList) {
        this.basketProductList = basketProductList;
    }
}
