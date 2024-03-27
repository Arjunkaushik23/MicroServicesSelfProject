package com.user.service.com.first.user.service.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.com.first.user.service.entities.User;
import com.user.service.com.first.user.service.services.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUser(User user){
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.ACCEPTED);
		
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User saveUser = this.userService.saveUser(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.ACCEPTED);

	}
	
	
	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public  ResponseEntity<User> getUserById(@PathVariable String userId){
		User userById = userService.getUserById(userId);
		return ResponseEntity.ok(userById);
	}
	
	// creating method for fallback in circuit beaker
	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex){
		ex.printStackTrace();
		logger.info("FallBack Method is Called Because service is down" +ex.getMessage());
		User user = User.builder().userEmail("dummy@gmail.com").userName("Dummy Singh").about("User is for dummy values").userId("123123").build();
		return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
	}

}
