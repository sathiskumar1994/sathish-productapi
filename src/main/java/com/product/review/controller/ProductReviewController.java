package com.product.review.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.entity.Product;
import com.product.review.exception.ResourceNotFoundException;
import com.product.review.repository.ProductRepository;

@RestController
@RequestMapping("/ProductReviewController")
public class ProductReviewController {
	
 @Autowired
 private ProductRepository productRepository;
 
 
 @PostMapping("/saveProduct")
 public Product saveProduct(@RequestBody Product product) {
   return productRepository.save(product);
 }
 
 
 /*@PostMapping("/product/review")
 public Product productReview(@RequestBody Review review){
	 return productRepository.save(review);
 }*/
 
 @GetMapping("/retriveProductInfo/{productId}")
 public Product retriveProductInfo(@PathVariable (value="productId") Long productId) throws ResourceNotFoundException
	{
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + productId));;
		return product;
	}

}
