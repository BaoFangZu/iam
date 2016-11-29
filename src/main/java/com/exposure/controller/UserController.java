package com.exposure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exposure.model.User;
import com.exposure.projection.SecretUserPassword;
import com.exposure.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

		@Autowired
		UserService userService;
		
		@RequestMapping(method=RequestMethod.GET)
		public List<User> findUsers(
				@RequestParam(value="username",required=false) String username,
				@RequestParam(value="email",required=false) String email,
				@RequestParam(value="phone",required=false) String phone
				){
			return userService.findByUsernameOrEmailOrPhone(username, email, phone);
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public User addUser(@RequestBody User user){
			return userService.addUser(user);
		}
		
		@RequestMapping(method=RequestMethod.PUT)
		public User update(@RequestBody User user){
			return userService.update(user);
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
		public void delUser(@PathVariable long id){
			userService.delete(id);
		}
		
		@RequestMapping(value="/all", method=RequestMethod.GET)
		public Iterable<User> findAllUsers(){
			return userService.findAll();
		}
		
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public User findOne(@PathVariable long id){
			return userService.findOne(id);
		}
}
