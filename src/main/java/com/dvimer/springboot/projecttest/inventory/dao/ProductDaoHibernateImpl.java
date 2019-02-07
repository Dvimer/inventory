package com.dvimer.springboot.projecttest.inventory.dao;

import com.dvimer.springboot.projecttest.inventory.entity.Product;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDaoHibernateImpl implements ProductDao
{
	private EntityManager entityManager;

	@Autowired
	public ProductDaoHibernateImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> findAll()
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> from_product = currentSession.createQuery("from Product", Product.class);
		return from_product.getResultList();
	}

	@Override
	public List<Product> findByName(String name)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Product> query = currentSession.createQuery("from Product as p where p.name=:productName",Product.class);
		query.setParameter("productName", name);

		return query.getResultList();
	}

	@Override
	public void save(Product product)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(product);
	}

	@Override
	public void delete(int id)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Product where id=:productId");
		query.setParameter("productId", id);
		query.executeUpdate();
	}
}
