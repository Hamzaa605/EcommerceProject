package com.learn.Ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.Ecommerce.entity.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {

     Optional<User> findByEmailId(String emailId);
     
     
     List<User> findByFirstNmae(String firstNmae);
     
     List<User> findByFirstNmaeStartingWith(String firstNmae);
     
     
     
     List<User> findByLastName(String lastName);
}
