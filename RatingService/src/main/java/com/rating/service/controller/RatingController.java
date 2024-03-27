package com.rating.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rating.service.entities.Rating;
import com.rating.service.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping("/")
	public ResponseEntity<Rating> createUser(@RequestBody Rating rating) {
		Rating createRating = this.ratingService.createRating(rating);
		return new ResponseEntity<Rating>(createRating, HttpStatus.CREATED);
	}

	
	@GetMapping("/")
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> allRating = this.ratingService.getAllRating();
		return new ResponseEntity<List<Rating>>(allRating, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingbyId(@PathVariable String ratingId) {
		Rating ratingById = this.ratingService.getRatingById(ratingId);
		return new ResponseEntity<Rating>(ratingById, HttpStatus.ACCEPTED);
	}

	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
		List<Rating> ratingByUserId = this.ratingService.getRatingByUserId(userId);
		return new ResponseEntity<List<Rating>>(ratingByUserId, HttpStatus.OK);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId) {
		List<Rating> ratingByHotelId = this.ratingService.getRatingByHotelId(hotelId);
		return new ResponseEntity<List<Rating>>(ratingByHotelId, HttpStatus.OK);
	}

}
