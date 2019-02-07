package com.dvimer.springboot.projecttest.inventory.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "brand")
	private String brand;
	@Column(name = "price")
	private BigDecimal price;
	@Column(name = "quantity")
	private int quantity;

	public Product()
	{
	}

	public Product(String name, String brand, BigDecimal price, int quantity)
	{
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	@Override
	public String toString()
	{
		final StringBuilder sb = new StringBuilder("Product{");
		sb.append("id=").append(id);
		sb.append(", name='").append(name).append('\'');
		sb.append(", brand='").append(brand).append('\'');
		sb.append(", price=").append(price);
		sb.append(", quantity=").append(quantity);
		sb.append('}');
		return sb.toString();
	}
}
