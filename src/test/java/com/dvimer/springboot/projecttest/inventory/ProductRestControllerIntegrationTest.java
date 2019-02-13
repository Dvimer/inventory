package com.dvimer.springboot.projecttest.inventory;


import com.dvimer.springboot.projecttest.inventory.entity.Product;
import com.dvimer.springboot.projecttest.inventory.rest.ProductRestController;
import com.dvimer.springboot.projecttest.inventory.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductRestController.class)
public class ProductRestControllerIntegrationTest
{
	@Autowired
	private MockMvc mvc;

	@MockBean
	private ProductService service;

	@Test
	public void givenProductsWhenGetProductsThenReturnJsonArray()
		throws Exception
	{

		Product product = new Product("orange", "orange", new BigDecimal(100), 4);
		Product product2 = new Product("orange", "orange", new BigDecimal(100), 4);

		List<Product> allProducts = Arrays.asList(product,product2);

		given(service.findAll()).willReturn(allProducts);

		mvc.perform(get("/api/products")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$", hasSize(2)))
			.andExpect(jsonPath("$[0].name", is(product.getName())))
			.andExpect(jsonPath("$[1].name", is(product2.getName())));
	}

	@Test
	public void deleteProduct()
		throws Exception
	{

//		Product product = new Product("orange", "orange", new BigDecimal(100), 4);
//
//		List<Product> allProducts = Collections.singletonList(product);
//
//		given(service.findByName(product.getName())).willReturn(allProducts);

		this.mvc.perform(MockMvcRequestBuilders
			.delete("/api/products", "1")
			.contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
	}
}