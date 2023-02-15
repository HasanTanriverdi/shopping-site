package com.akademi.basket.service;

import com.akademi.basket.dto.ProductDto;
import com.akademi.basket.entity.BasketProduct;
import com.akademi.basket.mapper.BasketProductMapper;
import com.akademi.basket.repository.BasketProductRepository;
import com.akademi.basket.response.BasketProductResponse;
import com.akademi.basket.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketProductService {

    @Autowired
    BasketProductRepository basketProductRepository;

    @Autowired
    BasketProductMapper basketProductMapper;

    public BasketProductResponse findBasketProdct(int basketProductId) {
        BasketProductResponse basketProductResponse = new BasketProductResponse();
        BasketProduct basketProduct = basketProductRepository.findBasketProductByBasketProductId(basketProductId);
        basketProductResponse.basketProduct = basketProductMapper.toDto(basketProduct);
        return basketProductResponse;
    }

    public BasketProduct createBasketProduct(int count, ProductResponse response) {
        BasketProduct basketProduct = new BasketProduct();
        basketProduct.setCount(count);
        basketProduct.setAmount(response.product.price * count);
        basketProduct.setProductId(response.product.productId);
        basketProduct = basketProductRepository.save(basketProduct);
        return basketProduct;
    }

    public BasketProduct findBasketProductByProductId(int productId) {
        BasketProduct basketProduct = basketProductRepository.findBasketProductByProductId(productId);
        return basketProduct;
    }
}
