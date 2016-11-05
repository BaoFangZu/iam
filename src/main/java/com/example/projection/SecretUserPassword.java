package com.example.projection;

import org.springframework.beans.factory.annotation.Value;

import com.example.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

//@Projection(name = "secretUserPassword", types = { User.class })
public interface SecretUserPassword {
	int getId();
	//@Value("#{target.username}")
	String getName();
	String getPhone();
	String getEmail();
	@Value("*******")
	String getPassword();
	String getTest();
}
