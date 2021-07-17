package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.AccountDTO;
import com.company.dto.DepartmentDTO;
import com.company.entity.Department;
import com.company.service.IDepartmentService;


@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {
	
	@Autowired
	private IDepartmentService service;
	
	@GetMapping
	public ResponseEntity<?> getAllDepartment(){
		List<Department> departments = service.getAllDepartments();
		
		List<DepartmentDTO> dtos = new ArrayList<>();
		
		// convert entities to Dto
		for (Department department : departments) {
			AccountDTO accountDTO = new AccountDTO(department.getAuthor().getId(), department.getAuthor().getFullName());
			DepartmentDTO dto = new DepartmentDTO(	department.getId(), 
													department.getName(), 
													accountDTO,
													department.getCreateDate());
			dtos.add(dto);
		}
		return new ResponseEntity<>(dtos, HttpStatus.OK);
	}
	
}
