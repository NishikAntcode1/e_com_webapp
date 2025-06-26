package com.e_com_webapp.dao;

import java.util.List;

import com.e_com_webapp.entity.Product;
import com.e_com_webapp.utils.HibernateUtil;

import jakarta.persistence.EntityManager;

public class ProductDao {
	
	public void save(Product product) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Product> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Product> products = em.createQuery("FROM Product", Product.class).getResultList();
        em.close();
        return products;
    }
	
	public Product findById(int id) {
        EntityManager em = HibernateUtil.getEntityManager();
        Product product = em.find(Product.class, id);
        em.close();
        return product;
    }
	
	public void update(Product product) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();
        em.close();
    }
	
	public void delete(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Product product = em.find(Product.class, id);
        if (product != null) {
            em.remove(product);
        }
        em.getTransaction().commit();
        em.close();
	}
	
}
