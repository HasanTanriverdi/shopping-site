package com.shopping.stock.controller;

import com.shopping.stock.dto.ProductDto;
import com.shopping.stock.response.CategoryResponse;
import com.shopping.stock.response.ProductResponse;
import com.shopping.stock.service.CategoryService;
import com.shopping.stock.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    ProductService productService;

    @GetMapping("/add/{productName}/{price}/{categoryId}/{quantity}")
    public ProductResponse add(@PathVariable(value = "productName")String productName,
                               @PathVariable (value = "price")int price,
                               @PathVariable (value = "categoryId")int categoryId,
                               @PathVariable (value = "quantity")int quantity){
        ProductResponse productResponse = productService.addProduct(productName,price,categoryId, quantity);
        return productResponse;
    }

    @GetMapping("/changePrice/{productId}/{price}")
    public ProductResponse changePrice(@PathVariable (value = "productId")int productId,
                                       @PathVariable (value = "price")int price){
        ProductResponse productResponse = productService.changePrice(productId, price);
        return productResponse;
    }

    @GetMapping("/find/{productId}")
    public ProductResponse findProduct(@PathVariable(value = "productId")String productId ){
        return productService.findProduct(Integer.parseInt(productId));
    }

    @PostMapping("/add")
    public ProductResponse add(@RequestBody ProductDto dto) {
        ProductResponse productResponse = productService.addProduct(dto);
        return productResponse;
    }
}
