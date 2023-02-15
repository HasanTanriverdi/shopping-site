package com.shopping.stock.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDto implements Serializable {
    public int categoryId;
    public String categoryName;
    public List<ProductDto> productList;
}
