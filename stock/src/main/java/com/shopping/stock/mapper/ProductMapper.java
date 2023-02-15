package com.shopping.stock.mapper;

import com.shopping.stock.dto.ProductDto;
import com.shopping.stock.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends IEntityMapper<ProductDto, Product>{
}
