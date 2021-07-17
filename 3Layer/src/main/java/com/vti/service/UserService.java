package com.vti.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vti.entity.User;
import com.vti.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userRepository.getAllUser();
	}

	@Override
	public User getUserByID(short id) {
		// TODO Auto-generated method stub
		return userRepository.getUserByID(id);
	}

	@Override
	public User getUserByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.getUserByName(name);
	}

	@Override
	public void createUser(User user) {
		userRepository.createUser(user);
		
	}

	@Override
	public void updateUser(short id, String newName) {
		userRepository.updateUser(id, newName);
		
	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
		
	}

	@Override
	public void deleteUser(short id) {
		userRepository.deleteUser(id);
		
	}

	@Override
	public boolean isUserExistsByID(short id) {
		return userRepository.isUserExistsByID(id);
	}

	@Override
	public boolean isUserExistsByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.isUserExistsByName(name);
	}

}
