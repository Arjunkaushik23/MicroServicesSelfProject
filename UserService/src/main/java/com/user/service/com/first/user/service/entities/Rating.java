package com.user.service.com.first.user.service.entities;

import lombok.AllArgsConstructor;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	

	private String ratingId;
	private String userId;
	private String hotelId;
	private String rating;
	private String remark;
	
	private Hotel hotel;
	

}
