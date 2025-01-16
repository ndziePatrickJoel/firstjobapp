package com.embarkx.firstjobapp.review.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.embarkx.firstjobapp.company.Company;
import com.embarkx.firstjobapp.company.CompanyRepository;
import com.embarkx.firstjobapp.review.Review;
import com.embarkx.firstjobapp.review.ReviewRepository;
import com.embarkx.firstjobapp.review.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	private ReviewRepository reviewRepository;
	
	private CompanyRepository companyRepository;
	
	public ReviewServiceImpl(ReviewRepository repo, CompanyRepository companyRepo)
	{
		this.reviewRepository = repo;
		this.companyRepository = companyRepo;
	}
	
	
	@Override
	public Review createReview(Review review, Long companyId) {
		Company company = this.companyRepository.findById(companyId).orElseThrow();
		review.setCompany(company);
		return this.reviewRepository.save(review);
	}

	@Override
	public List<Review> getAllReviews() {
		
		return this.reviewRepository.findAll();
	}

	@Override
	public Optional<Review> getReviewById(Long id) {
		
		return this.reviewRepository.findById(id);
	}

	@Override
	public void deleteReviewById(Long id) {
		
		this.reviewRepository.deleteById(id);
	}

	@Override
	public Review updateReview(Long id, Review update) {
		
		Review review = this.reviewRepository.findById(id).orElseThrow();
		
		review.setRating(update.getRating());
		review.setDescription(update.getDescription());
		review.setTitle(update.getTitle());
		
		this.reviewRepository.save(review);
		
		return review;
	}


	@Override
	public List<Review> getAllCompanyReview(Long companyId) 
	{
		return this.reviewRepository.findByCompanyId(companyId);
	}

}
