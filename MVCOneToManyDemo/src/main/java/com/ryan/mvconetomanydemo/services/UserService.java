package com.ryan.mvconetomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ryan.mvconetomanydemo.models.User;
import com.ryan.mvconetomanydemo.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public User getOne(Long id) {
		Optional<User> user = userRepo.findById(id);
		return user.isPresent() ? user.get() : null;
	}

	public List<User> getAll(){
		return userRepo.findAll();
	}
	
}
