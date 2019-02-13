package com.dvimer.springboot.projecttest.inventory.client;

import com.dvimer.springboot.projecttest.inventory.entity.Product;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

// TODO: 2/13/19 Перенести в тесты
public class RestClientUtil
{
	private HttpHeaders getHeaders()
	{
		String credential = "user:123";
		String encodedCredential = new String(Base64.encodeBase64(credential.getBytes()));;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Basic " + encodedCredential);
		return headers;
	}

	public void getProductByName()
	{
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/products/name/nPhone";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product[].class);
		Product[] products = responseEntity.getBody();
		for (Product product : products)
		{
			System.out.println(product);
		}
	}

	public void getAllProductsDemo()
	{
		HttpHeaders headers = getHeaders();
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/api/products";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Product[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Product[].class);
		Product[] products = responseEntity.getBody();
		for (Product product : products)
		{
			System.out.println(product);
		}
	}

	private void printPersonInfo(Product product)
	{
		if (product == null) return;
		System.out.println("Name:" + product.getName() + ", Brand:" + product.getBrand()
			+ ", Quantity: " + product.getQuantity()+ ", Price: " + product.getPrice());
	}

//	public void addProductDemo()
//	{
//		HttpHeaders headers = getHeaders();
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/product";
//		Product objProduct = new Product();
//		objProduct.setTitle("Spring REST Security using Hibernate");
//		objProduct.setCategory("Spring");
//		HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
//		URI uri = restTemplate.postForLocation(url, requestEntity);
//		System.out.println(uri.getPath());
//	}

//	public void updateProductDemo()
//	{
//		HttpHeaders headers = getHeaders();
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/product";
//		Product objProduct = new Product();
//		objProduct.setProductId(1);
//		objProduct.setTitle("Update:Java Concurrency");
//		objProduct.setCategory("Java");
//		HttpEntity<Product> requestEntity = new HttpEntity<Product>(objProduct, headers);
//		restTemplate.put(url, requestEntity);
//	}

//	public void deleteProductDemo()
//	{
//		HttpHeaders headers = getHeaders();
//		RestTemplate restTemplate = new RestTemplate();
//		String url = "http://localhost:8080/user/product/{id}";
//		HttpEntity<Product> requestEntity = new HttpEntity<Product>(headers);
//		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
//	}

	public static void main(String args[])
	{
		RestClientUtil util = new RestClientUtil();
		util.getProductByName();
		util.getAllProductsDemo();
		//util.addProductDemo();
//		util.updateProductDemo();
		//util.deleteProductDemo();
	}
}