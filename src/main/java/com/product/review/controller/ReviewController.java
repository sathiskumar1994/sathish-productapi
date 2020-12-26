package com.product.review.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.review.entity.Review;
import com.product.review.exception.ResourceNotFoundException;
import com.product.review.repository.ReviewRepository;


@RestController
@RequestMapping("/ReviewController")
public class ReviewController {

	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@GetMapping("/retriveReviewGroupId/{productId}")
	public ResponseEntity<Long> retriveReviewGroupId(@PathVariable (value="productId") Long productId) throws ResourceNotFoundException
	{
		long reviewGroupId = 0;
		Review review = reviewRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + productId));;
		
		reviewGroupId = review.getReviewGroupId();
		return ResponseEntity.ok().body(reviewGroupId);
	}
	
	@PostMapping("/addProductReview")
	public Review addProductReview(@RequestBody Review review){
		return reviewRepository.save(review);
	}
	
	@GetMapping("/retrive/listOfReviews")
	public ResponseEntity<ArrayList> retriveListOfReviews() throws ResourceNotFoundException
	{
		ArrayList<Review> reviewList = (ArrayList<Review>) reviewRepository.findAll(Sort.by(Sort.Direction.DESC, "ratings"));
		return ResponseEntity.ok().body(reviewList);
	}
	
	
	@GetMapping("/average/starRating")
	public ResponseEntity<Double> retriveAverageStarRating() throws ResourceNotFoundException
	{
		int averageRating =0 ;	
		double calculateAverageRating=0;
		ArrayList<Review> reviewList = new ArrayList<>();
		reviewList = (ArrayList<Review>) reviewRepository.findAll();
		Review review = null;
		ArrayList ratingList = new ArrayList<>();
		for(int i=0;i<reviewList.size();i++){
			review = (Review) reviewList.get(i);
			ratingList.add(review.getRatings());
		}
		for(int i = 1;i < ratingList.size();i++) {
			averageRating += (int)ratingList.get(i);
	      }
		calculateAverageRating = averageRating/2;
		return ResponseEntity.ok().body(calculateAverageRating);
	}

}
