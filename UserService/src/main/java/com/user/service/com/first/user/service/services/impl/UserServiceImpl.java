package com.user.service.com.first.user.service.services.impl;

import java.util.Arrays;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.service.com.first.user.service.entities.Hotel;
import com.user.service.com.first.user.service.entities.Rating;
import com.user.service.com.first.user.service.entities.User;
import com.user.service.com.first.user.service.exceptions.ResourceNotFoundException;
import com.user.service.com.first.user.service.external.services.HotelService;
import com.user.service.com.first.user.service.repositories.UserRepository;
import com.user.service.com.first.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private HotelService hotelService;

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User saveUser(User user) {
		String string = UUID.randomUUID().toString();
		user.setUserId(string);
		User savedUser = this.userRepository.save(user);
		return savedUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> findAllUsers = this.userRepository.findAll();
		return findAllUsers;
	}

	@Override
	public User getUserById(String userId) {
		User user = this.userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User Associated with this id could not be found" + userId));
		Rating[] ratingByUserId = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(),
				Rating[].class);
//		ratingService.getRating(userId);
//		logger.info("{} ", ratingByUserId);
		List<Rating> ratings = Arrays.stream(ratingByUserId).toList();
		List<Rating> collectedRatingList = ratings.stream().map(rating -> {
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			Hotel hotelObject = forEntity.getBody();
			Hotel hotelObject = hotelService.getHotel(rating.getHotelId());
			logger.info("{} ", hotelObject);
			rating.setHotel(hotelObject);
			return rating;
		}).collect(Collectors.toList());

		user.setRating(collectedRatingList);
		return user;
	}

}