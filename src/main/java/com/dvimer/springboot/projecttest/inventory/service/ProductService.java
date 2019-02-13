package com.dvimer.springboot.projecttest.inventory.service;

import com.dvimer.springboot.projecttest.inventory.entity.Product;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ProductService
{
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	List<Product> findAll();
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	Product findById(int id);
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	List<Product> findByName(String name);
	@Secured({"ROLE_ADMIN"})
	List<Product> findByBrand(String brand);
	@Secured({"ROLE_ADMIN"})
	List<Product> leftovers();
	@Secured({"ROLE_ADMIN"})
	void save(Product product);
	@Secured({"ROLE_ADMIN"})
	void delete(int id);
}
