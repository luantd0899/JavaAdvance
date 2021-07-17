package com.vti.controller;

import java.util.List;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.AccountDto;
import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFromForUpdating;
import com.vti.service.DepartmentService;
import com.vti.service.IDepartmentService;

@RestController  // đánh dấu đây là 1 controller, RestController sẽ trả ra Json, Controller sẽ trả ra JSP
@RequestMapping(value = "api/v1/departments") // Đánh dấu đường link
@CrossOrigin("*")
public class DepartmentController {

	@Autowired 
	private IDepartmentService service;
	

	@GetMapping
	public ResponseEntity<?> getAllDepartments(
			Pageable pageable, 
			@RequestParam(required = false) String search,
			DepartmentFilterForm filter) {
		Page<Department> entitiesPage = service.getAllDepartments(pageable, search, filter);

		// convert page entity to page dto
		Page<DepartmentDto> dtoPage = entitiesPage.map(new Function<Department, DepartmentDto>() {
			@Override
			public DepartmentDto apply(Department entity) { 
				DepartmentDto dto = new DepartmentDto(entity.getId(), entity.getName(),
						new AccountDto(entity.getAuthor().getId(), entity.getAuthor().getFullName()),
						entity.getCreateDate());
				return dto;

			}
		});
		return new ResponseEntity<>(dtoPage, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
		Department department = service.getDepartmentByID(id);
		DepartmentDto departmentDto = new DepartmentDto(department.getId(), department.getName(),
				new AccountDto(department.getAuthor().getId(), department.getAuthor().getFullName()), department.getCreateDate());

		return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentFormForCreating form) {
		service.createDepartment(form);
		return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") short id,
			@RequestBody DepartmentFromForUpdating departmentUpdate) {
		service.updateDepartment(id, departmentUpdate);
		return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
		service.deleteDepartment(id);
		return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
	}

	// delete multiple departments
	@DeleteMapping
	public ResponseEntity<?> deleteDepartments(@RequestParam(name = "ids") List<Short> ids) {
		short count = (short) ids.size();
		service.deleteDepartments(ids);
		return new ResponseEntity<String>(count + " rows affected!", HttpStatus.OK);
	}

	// check name Department
	@GetMapping(value = "/name/{name}/exists")
	public ResponseEntity<?> existsByName(@PathVariable(name = "name") String name) {
		return new ResponseEntity<>(service.isDepartmentExistsByName(name), HttpStatus.OK);
	}
		
}
