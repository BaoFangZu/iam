package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByUsername(String username);
    
    //@Query("Select a.id,a.first_name,a.last_name from user a  left join pets b on a.id=b.owner")
    //public List<User> findAllWithPets();
}