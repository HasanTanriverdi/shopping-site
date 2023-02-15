package com.shopping.stock.service;

import com.shopping.stock.dto.ProductDto;
import com.shopping.stock.entity.Category;
import com.shopping.stock.entity.Product;
import com.shopping.stock.exception.ProductPriceException;
import com.shopping.stock.mapper.ProductMapper;
import com.shopping.stock.repository.ProductRepository;
import com.shopping.stock.response.Meta;
import com.shopping.stock.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductMapper productMapper;

    public ProductResponse addProduct(String productName, int price, int categoryId, int quantity) {
        ProductResponse productResponse = new ProductResponse();
        Product product = new Product();
        Category category = categoryService.findCategory(categoryId);
        product.setQuantity(quantity);
        product.setCategory(category);
        product.setProductName(productName);
        product.setPrice(price);
        product = productRepository.save(product);
        productResponse.product = productMapper.toDto(product);
        return productResponse;
    }

    public ProductResponse findProduct(int productId) {
        ProductResponse response = new ProductResponse();
        response.product = productMapper.toDto(productRepository.findByProductId(productId));
        return response;
    }

    public Product findByProductId(int productId) {
        return productRepository.findByProductId(productId);
    }

    public ProductResponse changePrice(int productId, int price) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.meta = new Meta(200,"");
        Product product = findByProductId(productId);
        product.setPrice(price);
        if (price==0){
            throw new ProductPriceException();
        }
        product = productRepository.save(product);
        productResponse.product = productMapper.toDto(product);
        return productResponse;
    }

    public ProductResponse addProduct(ProductDto dto) {
        ProductResponse productResponse = new ProductResponse();
        Product product = productMapper.toEntity(dto);
        Category category = categoryService.findCategory(dto.categoryId);
        product.setCategory(category);
        product=productRepository.save(product);
        productResponse.product = productMapper.toDto(product);
        return productResponse;
    }

}
