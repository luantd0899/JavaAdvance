package com.company.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.entity.CategoryProduct;

public interface ICategoryRepository extends JpaRepository<CategoryProduct, Integer> {

}
