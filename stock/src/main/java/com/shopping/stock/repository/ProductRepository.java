package com.shopping.stock.repository;

import com.shopping.stock.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByProductId (int productId);
}
