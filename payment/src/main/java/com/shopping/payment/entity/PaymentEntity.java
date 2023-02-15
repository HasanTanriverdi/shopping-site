package com.shopping.payment.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int paymentId;
    private double paymentPrice;
    private int basketId;

    public PaymentEntity() {
    }

    public PaymentEntity(int paymentId, double paymentPrice, int basketId) {
        this.paymentId = paymentId;
        this.paymentPrice = paymentPrice;
        this.basketId = basketId;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaymentPrice() {
        return paymentPrice;
    }

    public void setPaymentPrice(double paymentPrice) {
        this.paymentPrice = paymentPrice;
    }

    public int getBasketId() {
        return basketId;
    }

    public void setBasketId(int basketId) {
        this.basketId = basketId;
    }
}
