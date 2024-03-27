package com.rating.service.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.service.entities.Rating;
import com.rating.service.repository.RatingRepository;
import com.rating.service.service.RatingService;
import com.rating.service.service.exception.ResourceNotFoundException;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		String s = UUID.randomUUID().toString();
		rating.setRatingId(s);
		Rating savedRating = this.ratingRepository.save(rating);
		return savedRating;
	}

	@Override
	public List<Rating> getAllRating() {
		List<Rating> findAllRating = this.ratingRepository.findAll();
		return findAllRating;
	}

	@Override
	public Rating getRatingById(String ratingId) {
		Rating ratingAfterThat = this.ratingRepository.findById(ratingId)
				.orElseThrow(() -> new ResourceNotFoundException("Rating with this id may not be present" + ratingId));
		return ratingAfterThat;
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> findByUserId = ratingRepository.findByUserId(userId);
		return findByUserId;
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		List<Rating> findByHotelId = ratingRepository.findByHotelId(hotelId);
		return findByHotelId;
	}

}
