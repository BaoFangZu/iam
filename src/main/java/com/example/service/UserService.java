package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.projection.SecretUserPassword;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public User addUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return userRepo.save(user);
	}

	public void delete(long id) {
		// TODO Auto-generated method stub
		userRepo.delete(id);
	}

	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	public User findOne(long id) {
		// TODO Auto-generated method stub
		return userRepo.findOne(id);
	}
	
	public User update(User user){
		return userRepo.save(user);
		
	}

	public List<SecretUserPassword> getUsersByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.getUsersByEmail(email);
	}

	public List<User> findByUsernameOrEmailOrPhone(String username, String email, String phone) {
		// TODO Auto-generated method stub
		return userRepo.findByUsernameOrEmailOrPhone(username, email, phone);
	}

}
