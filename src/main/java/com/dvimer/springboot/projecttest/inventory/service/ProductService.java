package com.dvimer.springboot.projecttest.inventory.service;

import com.dvimer.springboot.projecttest.inventory.entity.Product;

import java.util.List;

public interface ProductService
{
	List<Product> findAll();

	List<Product> findByName(String name);

	void save(Product product);

	void delete(int id);
}
