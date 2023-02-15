package com.akademi.basket.mapper;

import com.akademi.basket.dto.BasketProductDto;
import com.akademi.basket.entity.BasketProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketProductMapper extends IEntityMapper<BasketProductDto, BasketProduct> {
}
