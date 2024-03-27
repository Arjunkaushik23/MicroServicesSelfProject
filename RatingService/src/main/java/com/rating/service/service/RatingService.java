package com.rating.service.service;

import java.util.List;

import com.rating.service.entities.Rating;

public interface RatingService {

	// create
	public Rating createRating(Rating rating);
	
	// get all ratings
	public List<Rating> getAllRating();
	
   // get rating by ratingId
	public Rating getRatingById(String ratingId);
	
	//get ratings by userId
	List<Rating>  getRatingByUserId(String userId);
	
	//get ratings by hotelId
	List<Rating> getRatingByHotelId(String hotelId);
	
}
