package com.akademi.basket.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
public class BasketProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int basketProductId;
    private int count;
    private int status;
    private double amount;
    private int productId;

    @ManyToOne
    @JoinColumn(name = "basketId")
    @JsonBackReference
    private Basket basket;

    public BasketProduct() {
    }

    public BasketProduct(int basketProductId, int count, int status, double amount, int productId, Basket basket) {
        this.basketProductId = basketProductId;
        this.count = count;
        this.status = status;
        this.amount = amount;
        this.productId = productId;
        this.basket = basket;
    }

    public int getBasketProductId() {
        return basketProductId;
    }

    public void setBasketProductId(int basketProductId) {
        this.basketProductId = basketProductId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
