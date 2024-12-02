package com.learn.Ecommerce.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.entity.User;
import com.learn.Ecommerce.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto addUser(UserDto userDto) {
		UUID randomUUID = UUID.randomUUID();
		String id = randomUUID.toString();
		
		userDto.setId(id);
		//userDto.setId(UUID.randomUUID().toString());
		
		User user = dtoToEntity(userDto);
		User savedUser = userRepository.save(user);
		
		UserDto savedDto = entityToDto(savedUser);
		
		return savedDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = userRepository.findAll();
		  List<UserDto> userDtoList = users.stream()
				                     .map(u->entityToDto(u))
		                             .collect(Collectors.toList());
		  
		return userDtoList;
	}

	@Override
	public UserDto getUserById(String id) {
		
		User orElseThrow = userRepository.findById(id)
				.orElseThrow(()->new RuntimeException(id +"not found"));
		// TODO Auto-generated method stub
		return entityToDto(orElseThrow);
	}

	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUser(String id) {
		User users = userRepository.findById(id)
				    .orElseThrow(()->new RuntimeException(id+" not found"));
		
		userRepository.delete(users);
		return users.getId()+"Deleted successfully";
	}

	@Override
	public UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstNmae(user.getFirstNmae());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setEmailId(user.getEmailId());
		userDto.setAge(user.getAge());
		userDto.setAddress(user.getAddress());
		
		
		return userDto;
	}

	@Override
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setFirstNmae(userDto.getFirstNmae());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setEmailId(userDto.getEmailId());
		user.setAge(userDto.getAge());
		user.setAddress(userDto.getAddress());
		
		return user;
	}
	
	@Override
	public UserDto getUserByEmailId(String emailId) {
		
		User user= userRepository.findByEmailId(emailId)
				.orElseThrow(()->new RuntimeException(emailId +"not found"));
		// TODO Auto-generated method stub
		return entityToDto(user);
	}

	@Override
	public List<UserDto> getUserByFirstName(String firstName) {
		List<User> listed = userRepository.findByFirstNmae(firstName);
		List<UserDto> user = listed.stream()
                .map(f->entityToDto(f))
                .collect(Collectors.toList());
		return user;
	}
	
	
	
	
}
