package com.akademi.basket.controller;


import com.akademi.basket.dto.AddBasketDto;
import com.akademi.basket.response.BasketResponse;
import com.akademi.basket.response.ProductResponse;
import com.akademi.basket.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    @Autowired
    BasketService basketService;


    @GetMapping("/add/{status}")
    public BasketResponse updateStatus(@PathVariable(value = "status") Integer status) {
        return basketService.updateBasket(status);
    }

    @PostMapping("/add")
    public BasketResponse addBasketProduct(@RequestBody AddBasketDto dto) {
        return basketService.addBasketProduct(dto);
    }

}
