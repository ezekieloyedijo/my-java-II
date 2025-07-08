package com.easyconcept.session1.solution2.serviceImpl;

import com.easyconcept.session1.solution2.dto.ProductDto;
import com.easyconcept.session1.solution2.dto.ResponseDto;
import com.easyconcept.session1.solution2.entity.Product;
import com.easyconcept.session1.solution2.repository.ProductRepository;
import com.easyconcept.session1.solution2.service.ProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo = new ProductRepository();

    @Override
    public void addProduct(ProductDto dto) {
        Product product = new Product(dto.name, dto.category, dto.price);
        repo.save(product);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        List<Product> matched = new ArrayList<>();
        for (Product product : repo.getAll()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                matched.add(product);
            }
        }
        return matched;
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.getAll();
    }

    @Override
    public Product getProductByName(String name) {
        return repo.findByName(name).orElse(null);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public ResponseDto updateProductPrice(String name, double newPrice) {
        if (repo.existsByName(name)) {
            repo.updatePrice(name, newPrice);
            return new ResponseDto(true, "Product price updated.");
        }
        return new ResponseDto(false, "Product not found.");
    }

    @Override
    public ResponseDto deleteProduct(String name) {
        if (repo.existsByName(name)) {
            repo.deleteByName(name);
            return new ResponseDto(true, "Product deleted.");
        }
        return new ResponseDto(false, "Product not found.");
    }
}
