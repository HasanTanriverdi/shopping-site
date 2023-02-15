package com.shopping.stock.service;

import com.shopping.stock.entity.Category;
import com.shopping.stock.mapper.CategoryMapper;
import com.shopping.stock.repository.CategoryRepository;
import com.shopping.stock.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryResponse addCategory(String categoryName){
        CategoryResponse categoryResponse = new CategoryResponse();
        Category category = new Category();
        category.setCategoryName(categoryName);
        category = categoryRepository.save(category);
        categoryResponse.category = categoryMapper.toDto(category);
        return categoryResponse;
    }

    public Category findCategory(int categoryId){
        return categoryRepository.findByCategoryId(categoryId);
    }
}
