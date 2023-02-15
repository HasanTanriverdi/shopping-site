package com.akademi.basket.api;

import com.akademi.basket.response.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ProductFeignCallableApi {
    @GetMapping("/stock/find/{productId}")
    ProductResponse findProductWithFeignClient(@PathVariable(name = "productId")int productId);
}
