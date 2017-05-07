package controllers;

import dao.Dao;
import model.Product;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ProductServletParameters extends ServletParameters {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("../newProduct");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request);
        response.sendRedirect("../products.html");
    }

    private void process(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("Utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product;
        if (id == 0) {
            product = new Product();
        } else {
            product = new Dao().getByID(Product.class, id);
        }

        process(request,product);
    }
}
