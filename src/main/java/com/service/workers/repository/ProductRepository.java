package com.service.workers.repository;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.service.workers.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByName(String name);
}
