package com.learn.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")

public class UserController {

	@Autowired
	UserService userService;
	
	//  POST ["/users"] to add user
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto)
	{
		UserDto savedUser = userService.addUser(userDto);
		
		return new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED);
	}
	
	// GET ["/users/{101}"] to fetch user by id
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String id)
	{
	  UserDto userDto = userService.getUserById(id);
	  
	  return new ResponseEntity<UserDto>(userDto,HttpStatus.FOUND);
	}
	
	// GET ["/user"] to fetch all users
	@GetMapping("/allusers")
	public ResponseEntity<List<UserDto>>  fetchAllUser()
	{
		List<UserDto> Users = userService.getAllUsers();
		
		return new ResponseEntity<List<UserDto>>(Users,HttpStatus.OK);
	}
	
	//DELETE ("/users/{id}")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id)
	{
		String msg = userService.deleteUser(id);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
