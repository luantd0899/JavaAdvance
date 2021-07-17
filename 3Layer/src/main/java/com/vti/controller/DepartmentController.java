package com.vti.controller;

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

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;
// Nhận đầu vào, tránh sự thay đổi
@RestController // trả ra data dạng json
@RequestMapping(value = "api/v1/departments") // tên đường link(api/version/...) theo chuẩn resful
public class DepartmentController {

	@Autowired // THAY THẾ CHO HÀM KHỞI TẠO KHÔNG THAM SỐ
	private IDepartmentService service;

	@GetMapping()
	public List<Department> getAllDepartments() {
		return service.getAllDepartments();
	}

	@GetMapping(value = "/{id}")
	public Department getDepartmentByID(@PathVariable(name = "id") short id) {
		return service.getDepartmentByID(id);
	}

	@PostMapping()
	public void createDepartment(@RequestBody Department department) {
		service.createDepartment(department);
	}

	@PutMapping(value = "/{id}")
	public void updateDepartment(@PathVariable(name = "id") short id, @RequestBody Department department) {
		department.setId(id);
		service.updateDepartment(department);
	}

	@DeleteMapping(value = "/{id}")
	public void deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
	}
}
