package controllers;

import dao.Dao;
import model.BaseEntity;
import model.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public abstract class ServletParameters extends HttpServlet {
    void process(HttpServletRequest request, BaseEntity entity) throws IOException {
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            String name = (String) en.nextElement();
            String value = request.getParameter(name);

            if (value != null) {
                entity.setValue(name, value);
            }
        }
        (new Dao()).update(entity);
    }
}
