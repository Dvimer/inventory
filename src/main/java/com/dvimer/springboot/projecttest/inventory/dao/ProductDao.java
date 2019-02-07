package com.dvimer.springboot.projecttest.inventory.dao;

import com.dvimer.springboot.projecttest.inventory.entity.Product;

import java.util.List;

public interface ProductDao
{
	List<Product> findAll();

	List<Product> findByName(String name);

//	Product findByBrand(String brand);

	void save(Product product);

	void delete(int id);
}
