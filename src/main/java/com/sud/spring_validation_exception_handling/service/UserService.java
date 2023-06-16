package com.sud.spring_validation_exception_handling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sud.spring_validation_exception_handling.dto.UserRequest;
import com.sud.spring_validation_exception_handling.entity.User;
import com.sud.spring_validation_exception_handling.exception.UserNotFoundException;
import com.sud.spring_validation_exception_handling.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User addUser(UserRequest request) {

		// this functionality provided by the lombok- build
		User user = User.build(0, request.getUserName(), request.getUserEmail(), request.getUserMobile(),
				request.getAge(), request.getAddress());

		return userRepository.save(user);
	}

	public List<User> getUserList() {
		return userRepository.findAll();
	}

	public User getUserByUserId(int id) throws UserNotFoundException{
		User user = userRepository.findByUserId(id);
		if(null != user) {
			return user;
		}else {
			throw new UserNotFoundException("Given userId not found in database !!");
		}
	}

	public void deleteUserByUserId(int id) throws UserNotFoundException {
		userRepository.delete(getUserByUserId(id));
	}
}
