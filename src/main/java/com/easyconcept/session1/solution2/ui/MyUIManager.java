package com.easyconcept.session1.solution2.ui;


import com.easyconcept.session1.solution2.dto.ProductDto;
import com.easyconcept.session1.solution2.entity.Product;
import com.easyconcept.session1.solution2.serviceImpl.ProductServiceImpl;


import java.util.List;
import java.util.Scanner;

public class MyUIManager {
    private final Scanner scanner = new Scanner(System.in);
    private final ProductServiceImpl service = new ProductServiceImpl();

    public void start() {
        while (true) {
            System.out.println("\n====== PRODUCT STORE MENU ======");
            System.out.println("1. Add new product");
            System.out.println("2. View all products");
            System.out.println("3. Search products by keyword");
            System.out.println("4. Find product by name");
            System.out.println("5. Filter products by category");
            System.out.println("6. Update product price");
            System.out.println("7. Delete product by name");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> addProduct();
                case 2 -> showAllProducts();
                case 3 -> searchProducts();
                case 4 -> findProductByName();
                case 5 -> filterByCategory();
                case 6 -> updatePrice();
                case 7 -> deleteProduct();
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private void addProduct() {
        ProductDto dto = new ProductDto();
        System.out.print("Enter product name: ");
        dto.name = scanner.nextLine();

        System.out.print("Enter product category: ");
        dto.category = scanner.nextLine();

        System.out.print("Enter product price: ");
        dto.price = scanner.nextDouble();
        scanner.nextLine();

        service.addProduct(dto);
        System.out.println("✅ Product added successfully!");
    }

    private void showAllProducts() {
        List<Product> all = service.getAllProducts();
        if (all.isEmpty()) {
            System.out.println("No products available.");
        } else {
            for (Product p : all) {
                System.out.printf("Name: %s | Category: %s | Price: %.2f%n",
                        p.getName(), p.getCategory(), p.getPrice());
            }
        }
    }

    private void searchProducts() {
        System.out.print("Enter keyword to search (name/category): ");
        String keyword = scanner.nextLine();

        List<Product> result = service.searchProducts(keyword);
        if (result.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            for (Product p : result) {
                System.out.printf("→ Name: %s | Category: %s | Price: %.2f%n",
                        p.getName(), p.getCategory(), p.getPrice());
            }
        }
    }

    private void findProductByName() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        Product product = service.getProductByName(name);
        if (product != null) {
            System.out.printf("Found → Name: %s | Category: %s | Price: %.2f%n",
                    product.getName(), product.getCategory(), product.getPrice());
        } else {
            System.out.println("Product not found.");
        }
    }

    private void filterByCategory() {
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        List<Product> list = service.getProductsByCategory(category);
        if (list.isEmpty()) {
            System.out.println("No products found in this category.");
        } else {
            for (Product p : list) {
                System.out.printf("→ %s | Price: %.2f%n", p.getName(), p.getPrice());
            }
        }
    }

    private void updatePrice() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.println(service.updateProductPrice(name, price).message);
    }

    private void deleteProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.println(service.deleteProduct(name).message);
    }
}