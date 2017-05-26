package controllers;

import dao.Dao;
import model.Product;
import model.User;
import org.hibernate.Hibernate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.data.annotation.Persistent;

import javax.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
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
        if (request.getParameterMap().size()!=2) {
            int id = Integer.parseInt(request.getParameter("id"));
            Dao dao = new Dao();
            User user;
            if (id == 0) {
                user = new User();
            } else {
                user = dao.getByID(User.class, id);
            }

            try {
                InputStream st = request.getPart("photo").getInputStream();
                Blob blob = new Dao().createBlob(st);
                user.setPhoto(blob);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            process(request, user);
        }
    }
}
