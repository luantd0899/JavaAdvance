package com.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.entity.Department;


@Repository
public interface IDepartmentRepository extends JpaRepository<Department, Short> {

	public Department findByName(String name);

	public boolean existsByName(String name);
	
	
}
