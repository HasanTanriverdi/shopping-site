package com.shopping.stock.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
    public int productId;
    public String productName;
    public double price;
    public int categoryId;
    public int quantity;
}
