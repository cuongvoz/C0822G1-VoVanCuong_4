package com.codegym.repository;

import com.codegym.model.Product;
import com.sun.org.apache.xpath.internal.objects.XNull;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static SessionFactory sessionFactory;
    private static EntityManager entityManager;
    static {
        sessionFactory = new Configuration().configure("hibernate.conf.xml").buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }



    @Override
    public List<Product> findAll() {
        List<Product> list;
        Session session = null;
        try {
            session  = sessionFactory.openSession();
            list = session.createQuery("FROM Product ").getResultList();
        } finally {
            session.close();
        }


        return list;
    }

    @Override
    public List<Product> findByName(String name,String description,double price) {
        List<Product> list = null;

        Session session = null;
        if (price == 0) {
            session = sessionFactory.openSession();
            list = (List<Product>) session.createQuery("FROM Product where name like CONCAT('%' , :name , '%') and description like concat('%' , :description , '%')")
                    .setParameter("name",name)
                    .setParameter("description",description).getResultList();
            session.close();
            return list;
        } else {
            session = sessionFactory.openSession();
            list = (List<Product>) session.createQuery("FROM Product where name like CONCAT('%' , :name , '%') and description like concat('%' , :description , '%')" +
                    "and price =:price")
                    .setParameter("name",name)
                    .setParameter("description",description)
                    .setParameter("price",price)
                    .getResultList();
            session.close();
            return list;
        }




    }

    @Override
    public void create(Product product) {
      Session session = null;
      Transaction transaction = null;
      try {
          session = sessionFactory.openSession();
          transaction = session.beginTransaction();
          session.persist(product);
          transaction.commit();
      } catch (Exception e) {
          e.printStackTrace();
          if (transaction != null) {
              transaction.rollback();
          }
      } finally {
          if (session != null) {
              session.close();
          }
      }
    }

    @Override
    public Product findByID(int id) {
        Session session = null;
        Product product = null;
        try {
            session = sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :id").setParameter("id",id).getSingleResult();
        } finally {
            session.close();
        }
        return product;
    }

    @Override
    public void delete(int id) {
        Product product = findByID(id);
      Session session = null;
      Transaction transaction = null;
      try {
          session = sessionFactory.openSession();
          transaction = session.beginTransaction();
          session.remove(product);
          transaction.commit();
      } finally {
          session.close();
      }
    }

    @Override
    public void update(Product product) {
     Session session = null;
        Transaction transaction = null;
        try {
           session = sessionFactory.openSession();
           transaction = session.beginTransaction();
           session.merge(product);
           transaction.commit();
        } catch (Exception e) {
           e.printStackTrace();
           if (transaction != null) {
               transaction.rollback();
           }
        } finally {
         if (session != null) {
             session.close();
         }
        }
    }
}
