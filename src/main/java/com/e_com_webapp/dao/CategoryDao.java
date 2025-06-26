package com.e_com_webapp.dao;

import com.e_com_webapp.entity.Category;
import com.e_com_webapp.utils.HibernateUtil;

import jakarta.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    public void save(Category category) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(category);
        em.getTransaction().commit();
        em.close();
    }

    public List<Category> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        List<Category> categories = em.createQuery("FROM Category", Category.class).getResultList();
        em.close();
        return categories;
    }

    public Category findById(int id) {
        EntityManager em = HibernateUtil.getEntityManager();
        Category category = em.find(Category.class, id);
        em.close();
        return category;
    }

    public void update(Category category) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(category);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(int id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Category category = em.find(Category.class, id);
        if (category != null) {
            em.remove(category);
        }
        em.getTransaction().commit();
        em.close();
    }
}
