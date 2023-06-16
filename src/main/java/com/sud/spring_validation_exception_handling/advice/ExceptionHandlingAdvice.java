package com.sud.spring_validation_exception_handling.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sud.spring_validation_exception_handling.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHandlingAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(errorFiled->
			errorMap.put(errorFiled.getField(), errorFiled.getDefaultMessage())
		);
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleNullPointerException(UserNotFoundException ex){
		Map<String, String> errorMap = new HashMap<>();
		errorMap.put("Message", ex.getMessage());
		return errorMap;
	}
}
