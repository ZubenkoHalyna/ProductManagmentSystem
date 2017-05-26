package dao;

import model.BaseEntity;
import model.Product;
import model.User;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Transient;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
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

    public <T extends BaseEntity> T getByID(Class<T> c, int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        T entity = (T) session.load(c, id);
        entity.toString();
        session.getTransaction().commit();
        return entity;
    }

    public void delete(BaseEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.load(entity.getClass(), entity.getId()));
        session.getTransaction().commit();
    }

    public void update(BaseEntity entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        if (entity.getId() == 0) {
            session.save(entity);
        } else {
            session.update(entity);
        }
        session.getTransaction().commit();
    }

    public <T extends BaseEntity> List<T> getAll(Class<T> c) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<T> list = session.createQuery("FROM "+c.getSimpleName()).list();
        session.getTransaction().commit();
        return list;
    }

    public <T extends BaseEntity> void delete(Class<T> c, int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(session.load(c, id));
        session.getTransaction().commit();
    }

    public Blob createBlob(InputStream st) {
        try {
            Blob b = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(st, st.available());
            return b;
        } catch (IOException e) {
            e.printStackTrace();
            throw (new RuntimeException(e));
        }
    }
}
