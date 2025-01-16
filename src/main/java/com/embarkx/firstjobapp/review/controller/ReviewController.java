package com.embarkx.firstjobapp.review.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.embarkx.firstjobapp.review.Review;
import com.embarkx.firstjobapp.review.ReviewService;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {

	private ReviewService reviewService;
	
	
	public ReviewController(ReviewService reviewService)
	{
		this.reviewService = reviewService;
	}
	
	@GetMapping
	public ResponseEntity<List<Review>> getAllCompanyReviews(@PathVariable Long companyId)
	{
		List<Review> reviews = this.reviewService.getAllCompanyReview(companyId);
		
		return ResponseEntity.ok(reviews);
	}
	
	@PostMapping
	public ResponseEntity<Review> createReview(@PathVariable Long companyId, @RequestBody Review newReview)
	{
		Review review = this.reviewService.createReview(newReview, companyId);
		
		return ResponseEntity.ok(review);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getReviewById(@PathVariable Long companyId, @PathVariable Long id)
	{
		Optional<Review> reviewOpt = this.reviewService.getReviewById(id);
		
		if(reviewOpt.isEmpty())
		{
			return new ResponseEntity<>("Item not found", HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(reviewOpt.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateReviewById(@PathVariable Long companyId, @PathVariable Long id, @RequestBody Review update)
	{
		Review updatedReview = this.reviewService.updateReview(id, update);
		
		return ResponseEntity.ok(updatedReview);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMapping(@PathVariable Long companyId, @PathVariable Long id)
	{
		this.reviewService.deleteReviewById(id);
		
		return new ResponseEntity<>("Item deleted", HttpStatus.OK);
	}
	
	
	
}
