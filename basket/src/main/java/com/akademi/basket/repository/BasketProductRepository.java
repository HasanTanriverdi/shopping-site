package com.akademi.basket.repository;

import com.akademi.basket.entity.BasketProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Integer> {
    public BasketProduct findBasketProductByBasketProductId (int basketProductId);
    public BasketProduct findBasketProductByProductId (int productId);
}
