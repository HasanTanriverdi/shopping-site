package com.shopping.stock.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> productList;

    public Category() {
    }

    public Category(int categoryId, String categoryName, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.productList = productList;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
