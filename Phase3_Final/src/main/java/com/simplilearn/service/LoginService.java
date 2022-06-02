package com.simplilearn.service;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.model.Admin;
import com.simplilearn.repo.AdminRepo;

@Service
public class LoginService {

	@Autowired
	AdminRepo adminRepo;
	
	@PostConstruct
	public void addAdmin()
	{
		adminRepo.save(new Admin("admin", "pwd"));
	}
	
	public boolean validateUser(String userid, String password) {
		
		Optional<Admin> admin = adminRepo.findById(userid);
		
		if (admin.isPresent())
		{
			return password.equals(admin.get().getPassword());
		}
		
		return false;
	}

	public void changePassword(String userid, String password)
	{
		Optional<Admin> admin = adminRepo.findById(userid);
		
		if (admin.isPresent())
		{
			admin.get().setPassword(password);
			adminRepo.save(admin.get());
		}
	}
}
