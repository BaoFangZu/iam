package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.User;
import com.example.projection.SecretUserPassword;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("Select u from User u where u.email = ?1")
    public List<SecretUserPassword> getUsersByEmail(String email);

	List<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);
}