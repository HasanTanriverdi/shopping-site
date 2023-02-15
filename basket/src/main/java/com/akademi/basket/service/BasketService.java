package com.akademi.basket.service;

import com.akademi.basket.api.ProductFeignCallableApi;
import com.akademi.basket.dto.AddBasketDto;
import com.akademi.basket.dto.ProductDto;
import com.akademi.basket.dto.UserDto;
import com.akademi.basket.entity.Basket;
import com.akademi.basket.entity.BasketProduct;
import com.akademi.basket.mapper.BasketMapper;
import com.akademi.basket.repository.BasketRepository;
import com.akademi.basket.response.BasketResponse;
import com.akademi.basket.response.ProductResponse;
import com.akademi.basket.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    BasketProductService basketProductService;

    @Autowired
    ProductFeignCallableApi productFeignCallableApi;

    @Autowired
    BasketMapper basketMapper;

    public BasketResponse updateBasket(int status) {
        BasketResponse basketResponse = new BasketResponse();
        Basket basket = new Basket();
        basket.setStatus(status);
        basket = basketRepository.save(basket);
        basketResponse.basket = basketMapper.toDto(basket);
        return basketResponse;
    }

    public BasketResponse addBasketProduct(AddBasketDto dto) {
        BasketResponse response = new BasketResponse();
        Basket basket = basketRepository.findBasketByUserId(dto.userId);
        if (basket != null) {
            basket = createAndAddProductNonEmptyBasket(dto.count, basket, dto.productId);
        } else {
            basket = createAndAddProductEmptyBasket(dto.count, dto.productId, dto.userId);
        }
        basketRepository.save(basket);
        response.basket = basketMapper.toDto(basket);
        return response;
    }

    private Basket createAndAddProductEmptyBasket(int count, int productId, int userId) {
        Basket basket = new Basket();
        ProductResponse product = productFeignCallableApi.findProductWithFeignClient(productId);
        basket.setUserId(userId);
        if (isSameStock(count, product)) {
            BasketProduct basketProduct = basketProductService.createBasketProduct(count, product);
            basket.setAmount(basket.getAmount() + basketProduct.getAmount());
            basketProduct.setBasket(basket);
            basketProduct.setCount(count);
            basketProduct.setBasket(basket);
            return basketRepository.save(basket);
        }
        return basket;
    }

    private Basket createAndAddProductNonEmptyBasket(int count, Basket basket, int productId) {
        int index = -1;
        for (BasketProduct basketProduct : basket.getBasketProductList()) {
            if (basketProduct.getProductId() == productId) {
                index = basket.getBasketProductList().indexOf(basketProduct);
            }
        }
        if (index != -1) {
            basket.getBasketProductList().get(index).setCount(basket.getBasketProductList().get(index).getCount() + count);
            basket.getBasketProductList().get(index).setAmount(basket.getBasketProductList().get(index).getCount() * productFeignCallableApi.findProductWithFeignClient(basket.getBasketProductList().get(index).getProductId()).product.price);
            basket.setAmount(basket.getAmount() + productFeignCallableApi.findProductWithFeignClient(basket.getBasketProductList().get(index).getProductId()).product.price*count);
        } else {
            ProductResponse product = productFeignCallableApi.findProductWithFeignClient(productId);
            BasketProduct basketProduct = basketProductService.createBasketProduct(count, product);
            basketProduct.setBasket(basket);
            basket.setAmount(basket.getAmount() + basketProduct.getAmount());
        }

        return basket;
    }

    public boolean isSameStock(int count, ProductResponse response) {
        return count <= response.product.quantity;
    }


}
