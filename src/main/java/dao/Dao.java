package dao;

import model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Transient;
import java.io.File;
import java.util.List;

public class Dao {
    static private SessionFactory sessionFactory;

    static {
        System.out.println("Connecting to DB...");
        try {
            File file = new File("hibernate.cfg.xml");
            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        System.out.println("Successfully connected to DB.\n");
    }

    public Product getByID(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Product p = (Product) session.load(Product.class, id);
        p.toString();
        session.getTransaction().commit();
        return p;
    }

    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.load(Product.class, id));
        session.getTransaction().commit();
    }

    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (product.getId() == 0) {
            session.save(product);
        } else {
            session.update(product);
        }
        session.getTransaction().commit();
    }

    public <T> List<T> getAll(Class<T> c) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<T> list = session.createQuery("FROM "+c.getSimpleName()).list();
        session.getTransaction().commit();
        return list;
    }
}
