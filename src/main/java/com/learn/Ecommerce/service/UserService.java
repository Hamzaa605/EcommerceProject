package com.learn.Ecommerce.service;

import java.util.List;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;

public interface UserService {
	
	//To add User
	UserDto addUser(UserDto userDto);
	
	//To fetch all users
	List<UserDto> getAllUsers();
	
	//To fetch all user by id
	UserDto getUserById(String id);
	
	// update user by Id
	UserDto updateUser(String id,UserDto userDto);
	
	// delete user by Id
	UserDto deleteUser(String id);

	// Entity to Dto conversion
	UserDto entityToDto(User user);
	
	// DTO to entity conversion
	User dtoToEntity(UserDto userDto);
}
