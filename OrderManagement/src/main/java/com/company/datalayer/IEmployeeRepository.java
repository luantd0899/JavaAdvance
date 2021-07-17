package com.company.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
	
}
