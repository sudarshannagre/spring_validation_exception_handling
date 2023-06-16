package com.sud.spring_validation_exception_handling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sud.spring_validation_exception_handling.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUserId(int id);

}
