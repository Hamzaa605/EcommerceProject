package com.learn.Ecommerce.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

//Dto = data transfer object
public class UserDto {

	private String id;
	@NotNull
	@NotBlank
	@Size(min = 2)
	private String firstNmae;
	@NotNull
	@NotBlank
	@Size(min = 3)
	private String lastName;
	@NotNull
	@NotBlank
	@Pattern(regexp = "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$")
	private String emailId;
	@NotNull
	@NotBlank
	@Pattern(regexp = "^(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[^\\w\\d\\s:])([^\\s]){8,16}$")
	private String password;
	@NotNull
	@NotBlank
	private String confrimPassword;
	@NotNull
	@Min(13)
	@Max(150)
	private int age;
	
}
