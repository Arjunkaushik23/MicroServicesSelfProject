package com.user.service.com.first.user.service.entities;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@Column(name = "ID")
	private String userId;

	@Column(name = "NAME")
	private String userName;

	@Column(name = "EMAIL")
	private String userEmail;

	@Column(name = "ABOUT")
	private String about;

	@Transient
	private List<Rating> Rating = new ArrayList<>();
	

}
