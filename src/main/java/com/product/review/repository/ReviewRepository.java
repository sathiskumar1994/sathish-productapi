package com.product.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.product.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	/*@Query("SELECT AVG(r.ratings) from review r")
	int getAverageRating();*/

}
