package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;

	public List<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
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
		return null;
	}

}
