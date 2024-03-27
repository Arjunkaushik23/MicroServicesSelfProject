package com.user.service.com.first.user.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.service.com.first.user.service.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

	// Custom methods here
}
