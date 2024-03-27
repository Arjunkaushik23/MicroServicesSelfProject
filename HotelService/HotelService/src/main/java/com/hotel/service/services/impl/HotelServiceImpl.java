package com.hotel.service.services.impl;

import java.util.List;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.service.entities.Hotel;
import com.hotel.service.repository.HotelRepository;
import com.hotel.service.services.HotelService;
import com.hotel.service.services.exceptions.ResourceNotFoundException;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel saveHotel(Hotel hotel) {
		String string = UUID.randomUUID().toString();
		hotel.setId(string);
		Hotel savedHotel = this.hotelRepository.save(hotel);
		return savedHotel;
	}

	@Override
	public List<Hotel> getAllHotel() {
		List<Hotel> findAllHotel = hotelRepository.findAll();
		return findAllHotel;
	}

	@Override
	public Hotel getHotelById(String id) {
		Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel id is not found "+ id));
		return hotel;
	}

	
}
