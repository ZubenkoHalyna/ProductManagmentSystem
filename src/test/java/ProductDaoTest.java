package model;

import dao.Dao;

import static java.lang.Thread.currentThread;

public class ProductDaoTest {
    @org.junit.Test
    public void getAll() throws Exception {
            Dao dao = new Dao();
        System.out.println(dao.getAll(Product.class));
    }

    @org.junit.Test
    public void getById() throws Exception {
        Dao dao = new Dao();
        System.out.println(dao.getByID(1));
    }


    @org.junit.Test
    public void addRemoveId() throws Exception {
        Dao dao = new Dao();
        Product p = new Product();
        p.setName("");
        p.setProducer("");
        p.setDescription("");
        dao.update(p);
        System.out.println("id = "+p.getId());
        dao.delete(p.getId());
    }
}

