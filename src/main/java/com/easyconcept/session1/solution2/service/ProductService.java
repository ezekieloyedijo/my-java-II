package com.easyconcept.session1.solution2.service;

import com.easyconcept.session1.solution2.dto.ProductDto;
import com.easyconcept.session1.solution2.dto.ResponseDto;
import com.easyconcept.session1.solution2.entity.Product;

import java.util.List;

public interface ProductService {
    void addProduct(ProductDto dto);
    List<Product> searchProducts(String keyword);
    List<Product> getAllProducts();
    Product getProductByName(String name);
    List<Product> getProductsByCategory(String category);
    ResponseDto updateProductPrice(String name, double newPrice);
    ResponseDto deleteProduct(String name);
}
