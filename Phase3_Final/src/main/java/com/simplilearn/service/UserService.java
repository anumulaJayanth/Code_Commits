package com.simplilearn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.User;
import com.simplilearn.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

//    @PostConstruct
//    public void preAddUsers()
//    {
//    	userRepo.save(new User("user1", "password1", "fname1", "lname1", "address1", "email1"));
//    	userRepo.save(new User("user2", "password2", "fname2", "lname2", "address2", "email2"));
//    	userRepo.save(new User("user3", "password3", "fname3", "lname3", "address3", "email3"));
//    }

	public List<User> retrieveUsers() {

		List<User> filteredUsers = (List<User>) userRepo.findAll();
		return filteredUsers;
	}

	public User retrieveUser(int id) {

		Optional<User> user = userRepo.findById(id);

		if (user.isPresent()) {
			return user.get();
		}

		return null;
	}

	public List<User> searchUsers(String keyword) {
		if (keyword != null) {
			return userRepo.search(keyword);
		}
		return (List<User>) userRepo.findAll();
	}

	public void updateUser(User user) {

		Optional<User> currentUser = userRepo.findById(user.getId());

		if (currentUser.isPresent()) {
			userRepo.delete(currentUser.get());
			userRepo.save(user);
		}
	}

	public void addUser(String username, String password, String firstname, String lastname, String address,
			String email) {

		System.out.println(username + " " + password + " " + firstname);
		userRepo.save(new User(username, password, firstname, lastname, address, email));
	}

	public void deleteUser(int id) {

		Optional<User> user = userRepo.findById(id);

		if (user.isPresent()) {
			userRepo.deleteById(id);
		}
	}
}