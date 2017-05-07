package model;

import dao.Dao;

import static java.lang.Thread.currentThread;

public class ProductDaoTest {
    @org.junit.Test
    public void getAllProducts() throws Exception {
            Dao dao = new Dao();
        System.out.println(dao.getAll(Product.class));
    }

    @org.junit.Test
    public void getAllUsers() throws Exception {
        Dao dao = new Dao();
        System.out.println(dao.getAll(User.class));
    }

    @org.junit.Test
    public void getById() throws Exception {
        Dao dao = new Dao();
        System.out.println(dao.getByID(Product.class,1));
    }


    @org.junit.Test
    public void addRemoveProduct() throws Exception {
        Dao dao = new Dao();
        Product p = new Product();
        p.setName("");
        p.setProducer("");
        p.setDescription("");
        dao.update(p);
        System.out.println("id = "+p.getId());
        dao.delete(p);
    }

    @org.junit.Test
    public void addRemoveUser() throws Exception {
        Dao dao = new Dao();
        User user = new User();
        user.setLogin("gala");
        user.setPassword("");
        user.setRole(UserRole.ADMIN);
        dao.update(user);
        System.out.println("id = "+user.getId());
        dao.delete(user);
    }
}

