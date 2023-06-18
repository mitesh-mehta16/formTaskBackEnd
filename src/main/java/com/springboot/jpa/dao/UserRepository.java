package com.springboot.jpa.dao;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.springboot.jpa.entities.User;


	public interface UserRepository 
	extends 
	CrudRepository<User, String> 
	{


}
