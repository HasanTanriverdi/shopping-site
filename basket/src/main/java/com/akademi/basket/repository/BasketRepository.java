package com.akademi.basket.repository;

import com.akademi.basket.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {
    public Basket findByBasketId(int basketId);
    public Basket findBasketByUserId(int userId);
}
