package com.exposure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exposure.client.ProjectClient;
import com.exposure.model.Project;
import com.exposure.model.User;
import com.exposure.projection.SecretUserPassword;
import com.exposure.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
//	@Autowired
//	ProjectClient projectClient;

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
	
	public Iterable<User> findByIds(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return userRepo.findAll(ids);
	}

	public User findOne(long id) {
		// TODO Auto-generated method stub
		User user = userRepo.findOne(id);
		//List<Project> projects = projectClient.findProjects(id);
		//user.setProjects(projects);
		return user;
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

	public Object findUserByIds(String ids) {
		// TODO Auto-generated method stub
		
		String[] idsArray = ids.split(",");
		List<Long> idsList = new ArrayList<Long>(); 
		

		for(String id : idsArray){
			idsList.add(Long.parseLong(id));
		}
		
		if (idsList.size() == 1){
			return findOne(idsList.get(0));
		}
		return userRepo.findAll(idsList);
	}

}
