package com.simplilearn.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE CONCAT(u.username, ' ', u.firstname, ' ', u.lastname, ' ', u.address, ' ', u.email, ' ') LIKE %?1%")
	public List<User> search(String keyword);
	
}
