package com.service.workers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.workers.model.Product;
import com.service.workers.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> addManyProduct(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProductByname(String name) {
        return productRepository.findAllByName(name);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public String delete(int id) {
        productRepository.deleteById(id);
        return "deleted " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProd = productRepository.findById(product.getId()).orElse(null);
        existingProd.setName(product.getName());
        existingProd.setQuantity(product.getQuantity());
        existingProd.setPrice(product.getPrice());
        return productRepository.save(existingProd);

    }

}
