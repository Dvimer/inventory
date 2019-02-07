package com.dvimer.springboot.projecttest.inventory.rest;

import com.dvimer.springboot.projecttest.inventory.entity.Product;
import com.dvimer.springboot.projecttest.inventory.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController
{
	private ProductService productService;

	@Autowired
	public ProductRestController(ProductService productService)
	{
		this.productService = productService;
	}

	@GetMapping("/products")
	public List<Product> findAll()
	{
		return productService.findAll();
	}

	@GetMapping("/products/name/{productName}")
	public List<Product> getProductByName(@PathVariable String productName)
	{
		List<Product> product = productService.findByName(productName);
		if (product == null)
		{
			throw new RuntimeException("Product is not name: " + productName);
		}
		return product;
	}

	@GetMapping("/products/brand/{productBrand}")
	public List<Product> getProductByBrand(@PathVariable String productBrand)
	{
		List<Product> product = productService.findByBrand(productBrand);
		if (product == null)
		{
			throw new RuntimeException("Product is not brand: " + productBrand);
		}
		return product;
	}

	@GetMapping("/products/levtovers")
	public List<Product> getLevtovers()
	{
		List<Product> product = productService.leftovers();
		if (product == null)
		{
			throw new RuntimeException("quantity product more than 5");
		}
		return product;
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product)
	{
		productService.save(product);
		return product;
	}

	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product)
	{
		productService.save(product);
		return product;
	}

	@DeleteMapping("/products/{productId}")
	public String delete(@PathVariable int productId)
	{
		Product product = productService.findById(productId);
		if (product == null)
		{
			throw new RuntimeException("Product id not found: " + productId);
		}
		productService.delete(productId);
		return "Deleted product id: " + productId;
	}
}

