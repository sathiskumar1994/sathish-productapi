package com.product.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.product.review.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
