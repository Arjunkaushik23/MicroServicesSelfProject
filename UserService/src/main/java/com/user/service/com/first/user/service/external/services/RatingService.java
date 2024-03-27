package com.user.service.com.first.user.service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.user.service.com.first.user.service.entities.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/ratings/users/{userId}")
	Rating getRating(@PathVariable String userId);

	// create Rating
	@PostMapping("/ratings/")
	Rating createRating(Rating valRating);

	// Update rating
	@PutMapping("/ratings/{ratingId}")
	Rating updateRating(@PathVariable String ratingId, Rating rating);
	
	//Delete Rating
	@DeleteMapping("/ratings/{ratingId}")
	Rating deleteRating(@PathVariable String ratingId);
}
