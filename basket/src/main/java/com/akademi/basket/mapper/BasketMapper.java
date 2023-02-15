package com.akademi.basket.mapper;

import com.akademi.basket.dto.BasketDto;
import com.akademi.basket.entity.Basket;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface BasketMapper extends IEntityMapper<BasketDto, Basket> {
}
