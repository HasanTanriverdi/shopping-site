package com.shopping.stock.repository;

import com.shopping.stock.entity.Category;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    public Category findByCategoryId (int categoryId);
}
