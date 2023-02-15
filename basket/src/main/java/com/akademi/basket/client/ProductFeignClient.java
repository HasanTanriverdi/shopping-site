package com.akademi.basket.client;

import com.akademi.basket.api.ProductFeignCallableApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("STOCK")
public interface ProductFeignClient extends ProductFeignCallableApi {
}
