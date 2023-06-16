package com.sud.spring_validation_exception_handling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sud.spring_validation_exception_handling.dto.UserRequest;
import com.sud.spring_validation_exception_handling.entity.User;
import com.sud.spring_validation_exception_handling.exception.UserNotFoundException;
import com.sud.spring_validation_exception_handling.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody @Valid UserRequest user) {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/list")
	public ResponseEntity<List<User>> getUserList() {
		return new ResponseEntity<List<User>>(userService.getUserList(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserByUserId(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<User>(userService.getUserByUserId(id), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserByUserId(@PathVariable int id) throws UserNotFoundException{
		userService.deleteUserByUserId(id);
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
