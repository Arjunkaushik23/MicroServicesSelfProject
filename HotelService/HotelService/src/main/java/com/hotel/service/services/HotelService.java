package com.hotel.service.services;

import java.util.List;

import com.hotel.service.entities.Hotel;


public interface HotelService {
	
	// create
	public Hotel saveHotel(Hotel hotel);
	
	//Get all
	public List<Hotel> getAllHotel();
	
	//Get by id
	public Hotel getHotelById(String id);
	

}
