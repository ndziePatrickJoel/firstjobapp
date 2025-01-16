package com.embarkx.firstjobapp.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
	
	 Review createReview(Review review, Long companyId);
	
	 List<Review> getAllReviews();
	
	 List<Review> getAllCompanyReview(Long companyId);
	
	 Optional<Review> getReviewById(Long id);
	
	 void deleteReviewById(Long id);
	
	 Review updateReview(Long id, Review update);
}
