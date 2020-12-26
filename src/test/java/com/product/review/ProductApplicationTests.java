package com.product.review;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.product.review.entity.Product;
import com.product.review.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProductApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
	void contextLoads() {
	}
	
		
	@Test
	public void testCreateUser() {
		Product product = new Product();
		product.setProductId(001);
		product.setProductName("Adidas Shoes");
		product.setProductPrice(2500);
		product.setProductType("FootWear");
		product.setImage("adidas_shoes.img");
		
		ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() + "/saveProduct", product, Product.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}

	@Test
	public void testRetriveProductInfo() {
		Product product = restTemplate.getForObject(getRootUrl() + "/retriveProductInfo/001", Product.class);
		System.out.println(product.getProductName());
		Assert.assertNotNull(product);
	}
	
	@Test
	public void testretriveReviewGroupId() {
		Review reviewGroupId = restTemplate.getForObject(getRootUrl() + "/retriveReviewGroupId/001", Review.class);
		Assert.assertNotNull(reviewGroupId);
	}
	
	@Test
	public void testAddProductReview() {
		Review review = new Review();
		review.setReviewGroupId(0001);
		review.setProductId("001");
		review.setComments("Amazing Product");
		review.setRatings(5);
		
		ResponseEntity<Review> postResponse= restTemplate.postForEntity(getRootUrl() + "/saveProduct", review, Review.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testRetriveListOfReviews() {
		Review reviewList = restTemplate.getForObject(getRootUrl() + "/retrive/listOfReviews", Review.class);
		Assert.assertNotNull(reviewList);
	}
	
	@Test
	public void testRetriveAverageStarRating() {
		Review averageStarRating = restTemplate.getForObject(getRootUrl() + "/retrive/listOfReviews", Review.class);
		Assert.assertNotNull(averageStarRating);
	}
	
	
	

}
