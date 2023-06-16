package com.sud.spring_validation_exception_handling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TABLE")
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private int userId;

	private String userName;

	private String userEmail;

	private long userMobile;

	private int age;

	private String address;

}
