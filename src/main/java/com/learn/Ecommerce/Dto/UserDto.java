package com.learn.Ecommerce.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Dto = data transfer object
public class UserDto {

	private String id;
	
	private String firstNmae;
	
	private String lastName;
	
	private String emailId;
	
	private String password;
	
	private String confrimPassword;
	
	private int age;
	
}
