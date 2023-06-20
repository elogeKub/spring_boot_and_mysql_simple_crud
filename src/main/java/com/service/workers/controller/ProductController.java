package com.service.workers.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.workers.model.Product;
import com.service.workers.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/add_product")
    public Product addProducts(@RequestBody Product product) {
        return productService.addProduct(product);

    }

    @PostMapping(value = "/add_more_products")
    public List<Product> addMoreProducts(@RequestBody List<Product> product) {
        return productService.addManyProduct(product);
    }

    @PutMapping(value = "/update_product")
    public Product updateProducts(@RequestBody Product product) {
        return productService.updateProduct(product);

    }

    @DeleteMapping(value = "/delete_product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productService.delete(id);
    }

    @GetMapping(value = "/display_product_by_name/{name}")
    public List<Product> getByName(@PathVariable String name) {
        return productService.getProductByname(name);
    }

    @GetMapping("/display_all_products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
