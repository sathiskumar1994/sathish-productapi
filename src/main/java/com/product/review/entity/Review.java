package com.product.review.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "review")
@EntityListeners(AuditingEntityListener.class)
public class Review {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long reviewGroupId;
	
	@Column(name = "comments", nullable = false)
	private String comments;
	
	@Column(name = "ratings", nullable = false)
	private int ratings;
	
	@Column(name = "product_id", nullable = false)
	private String productId;

	public long getReviewGroupId() {
		return reviewGroupId;
	}

	public void setReviewGroupId(long reviewGroupId) {
		this.reviewGroupId = reviewGroupId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
