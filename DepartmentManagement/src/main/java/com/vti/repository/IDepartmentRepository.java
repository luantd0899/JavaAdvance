package com.vti.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Short> {

	public Department findByName(String name);

	public boolean existsByName(String name);
	
	
	@Modifying
	@Transactional
	@Query("DELETE FROM Department WHERE id IN(:ids)")
	public void deleteByIds(@Param("ids") List<Short> ids);

	public Page<Department> findAll(Specification<Department> where, Pageable pageable);
}
