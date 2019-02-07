package com.dvimer.springboot.projecttest.inventory.dao;

import com.dvimer.springboot.projecttest.inventory.entity.Product;

import java.util.List;

public interface ProductDao
{
	List<Product> findAll();

	Product findById(int id);

	List<Product> findByName(String name);

	List<Product>  findByBrand(String brand);

	List<Product>  leftovers();

	void save(Product product);

	void delete(int id);

}
