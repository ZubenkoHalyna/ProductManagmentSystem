package controllers;
import dao.Dao;
import model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@Controller
public class ProductsController {

    @RequestMapping(value = "index.html")
    public String index(Model model) {
        return "/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping("/products.html")
    public String products(Model model) {
        model.addAttribute("listProducts", (new Dao()).getAll(Product.class));
        return "/WEB-INF/jsp/products.jsp";
    }

    @RequestMapping(value = "/info/{id}")
    public String showProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", (new Dao()).getByID(((int) id)));
        return "../WEB-INF/jsp/product.jsp";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", (new Dao()).getByID(((int) id)));
        return "../WEB-INF/jsp/productEdit.jsp";
    }

    @RequestMapping(value = "/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/WEB-INF/jsp/newProduct.jsp";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeProduct(@PathVariable("id") long id, Model model) {
        (new Dao()).delete((int) id);
        model.addAttribute("listProducts", (new Dao()).getAll(Product.class));
        return "../WEB-INF/jsp/products.jsp";
    }
}