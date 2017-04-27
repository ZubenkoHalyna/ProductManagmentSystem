package controllers;

import dao.Dao;
import model.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class ServletParameters extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      //  this.process(request, response);
        response.sendRedirect("../newProduct");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.process(request, response);
        response.sendRedirect("../products.html");
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        Product product;
        if (id == 0) {
            product = new Product();
        } else {
            product = dao.getByID(id);
        }

        // Get the values of all request parameters
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            // Get the name of the request parameter
            String name = (String) en.nextElement();
            String value = request.getParameter(name);

            if (value != null) {
                product.setValue(name, value);
            }
        }
        dao.update(product);
    }
}
