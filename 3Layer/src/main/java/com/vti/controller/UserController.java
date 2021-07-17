package com.vti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.User;
import com.vti.entity.enumerate.EUserGender;
import com.vti.entity.enumerate.EUserRole;
import com.vti.service.IUserService;


@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

	@Autowired
	private IUserService userService;

	@GetMapping()
	public List<User> get() {
		return userService.getAllUser();
	}

	@GetMapping(value = "/{id}")
	public User getUserById(@PathVariable(name = "id") short id) {
		return userService.getUserByID(id);
	}

	@PostMapping()
	public void createUser(@RequestBody User user) {
		userService.createUser(user);
	}

	@PutMapping(value = "/{id}")
	public void updateUser(@PathVariable(name = "id") short id, @RequestBody User user) {
		user.setEmail("luan1");
		user.setUsername("luan1");
		user.setPassword("luan1");
		user.setFirstName("luan1");
		user.setLastName("luan1");
		user.setGender(EUserGender.F);
		user.setDateOfBirth(new Date());
		user.setAddress("luan1");
		user.setPhone("0942273195");
		user.setRole(EUserRole.EMPLOYEE);
		user.setStatus((short)1);
		userService.updateUser(user);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		userService.deleteUser(id);
	}
}
