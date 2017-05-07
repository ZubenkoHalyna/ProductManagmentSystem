package controllers;

import dao.Dao;
import model.Product;
import model.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class UserServletParameters extends ServletParameters {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("../newUser");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        process(request);
        response.sendRedirect("../users.html");
    }

    private void process(HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("Utf-8");
        //TODO analysis request.getRequestURI();
        int id = Integer.parseInt(request.getParameter("id"));
        Dao dao = new Dao();
        User user;
        if (id == 0) {
            user = new User();
        } else {
            user = dao.getByID(User.class, id);
        }

        process(request,user);
    }
}
