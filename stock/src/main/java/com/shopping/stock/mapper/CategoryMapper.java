package com.shopping.stock.mapper;

import com.shopping.stock.dto.CategoryDto;
import com.shopping.stock.entity.Category;
import org.mapstruct.Mapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.salesforce.atrium")
@Mapper(componentModel = "spring")
public interface CategoryMapper extends IEntityMapper<CategoryDto, Category>{
}
