package com.easyconcept.session1.solution2.repository;

import com.easyconcept.session1.solution2.entity.Product;

import java.util.*;

public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();

    public void save(Product product) {
        productList.add(product);
    }

    public List<Product> getAll() {
        return productList;
    }

    public Optional<Product> findByName(String name) {
        return productList.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();
    }

    public List<Product> findByCategory(String category) {
        List<Product> matched = new ArrayList<>();
        for (Product product : productList) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                matched.add(product);
            }
        }
        return matched;
    }

    public void updatePrice(String name, double newPrice) {
        findByName(name).ifPresent(product -> {
            productList.remove(product);
            productList.add(new Product(product.getName(), product.getCategory(), newPrice));
        });
    }

    public void deleteByName(String name) {
        productList.removeIf(p -> p.getName().equalsIgnoreCase(name));
    }

    public boolean existsByName(String name) {
        return productList.stream()
                .anyMatch(p -> p.getName().equalsIgnoreCase(name));
    }
}
