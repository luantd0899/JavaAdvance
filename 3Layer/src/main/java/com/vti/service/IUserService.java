package com.vti.service;

import java.util.List;

import com.vti.entity.User;

public interface IUserService {
	public List<User> getAllUser();

	public User getUserByID(short id);

	public User getUserByName(String name);

	public void createUser(User user);

	public void updateUser(short id, String newName);

	public void updateUser(User user);

	public void deleteUser(short id);

	public boolean isUserExistsByID(short id);

	public boolean isUserExistsByName(String name);
}
