package com.sud.spring_validation_exception_handling.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")//functionality of lombok
@NoArgsConstructor
public class UserRequest {

	@NotBlank(message = "UserName should not be blank and null")
	private String userName;

	@Email
	private String userEmail;

	@NotNull
	private long userMobile;

	@Min(10)
	@Max(80)
	private int age;

	@NotBlank(message = "Address should not be blank and null")
	private String address;
}
