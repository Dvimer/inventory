package com.dvimer.springboot.projecttest.inventory.service;

import com.dvimer.springboot.projecttest.inventory.dao.ProductDao;
import com.dvimer.springboot.projecttest.inventory.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
	private ProductDao productDao;

	@Autowired
	public ProductServiceImpl(ProductDao productDao)
	{
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> findAll()
	{
		return productDao.findAll();
	}

	@Override
	@Transactional
	public Product findById(int id)
	{
		return productDao.findById(id);
	}

	@Override
	@Transactional
	public List<Product> findByName(String name)
	{
		return productDao.findByName(name);
	}

	@Override
	@Transactional
	public List<Product> findByBrand(String brand)
	{
		return productDao.findByBrand(brand);
	}

	@Override
	@Transactional
	public List<Product> leftovers()
	{
		return productDao.leftovers();
	}

	@Override
	@Transactional
	public void save(Product product)
	{
		productDao.save(product);
	}

	@Override
	@Transactional
	public void delete(int id)
	{
		productDao.delete(id);
	}
}
