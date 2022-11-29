package com.mustache.hospitals.repository;

import com.mustache.hospitals.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
