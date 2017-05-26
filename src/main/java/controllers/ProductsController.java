package controllers;
import dao.Dao;
import model.Product;
import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {

    @RequestMapping(value = "index.html")
    public String index(Model model) {
        return "/WEB-INF/jsp/index.jsp";
    }

    @RequestMapping(value = "login.html")
    public String login(Model model) {
        model.addAttribute("IndexPageAddress","../index.html");
        return "/WEB-INF/jsp/login.jsp";
    }

    @RequestMapping(value = "error.html")
    public String error(Model model) {
        model.addAttribute("IndexPageAddress","../index.html");
        return "/WEB-INF/jsp/error.jsp";
    }

    @RequestMapping("/products.html")
    public String products(Model model) {
        model.addAttribute("listProducts", (new Dao()).getAll(Product.class));
        model.addAttribute("IndexPageAddress","../index.html");
        return "/WEB-INF/jsp/products.jsp";
    }

    @RequestMapping("/users.html")
    public String users(Model model) {
        model.addAttribute("listUsers", (new Dao()).getAll(User.class));
        model.addAttribute("IndexPageAddress","../index.html");
        return "/WEB-INF/jsp/users.jsp";
    }

    @RequestMapping(value = "/product/{id}/info")
    public String showProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", (new Dao()).getByID(Product.class,((int) id)));
        return "../../WEB-INF/jsp/productInfo.jsp";
    }

    @RequestMapping(value = "/user/{id}/info")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", (new Dao()).getByID(User.class,((int) id)));
        return "../../WEB-INF/jsp/userInfo.jsp";
    }

    @RequestMapping(value = "/user/{id}/getPhoto")
    public String getUserPhoto(@PathVariable("id") long id, Model model) {
        model.addAttribute("id", (int) id);
        return "../../WEB-INF/jsp/getImage.jsp?id="+id;
    }

    @RequestMapping(value = "/product/{id}/edit")
    public String editProduct(@PathVariable("id") long id, Model model) {
        model.addAttribute("product", (new Dao()).getByID(Product.class,((int) id)));
        model.addAttribute("ProductsPageAddress","../../products.html");
        return "../../WEB-INF/jsp/productEdit.jsp";
    }

    @RequestMapping(value = "/user/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", (new Dao()).getByID(User.class,((int) id)));
        model.addAttribute("UsersPageAddress","../../users.html");
        return "../../WEB-INF/jsp/userEdit.jsp";
    }

    @RequestMapping(value = "/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("ProductsPageAddress","../products.html");
        return "/WEB-INF/jsp/productEdit.jsp";
    }

    @RequestMapping(value = "/newUser")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("UsersPageAddress","../users.html");
        return "/WEB-INF/jsp/userEdit.jsp";
    }

    @RequestMapping(value = "/product/{id}/remove")
    public String removeProduct(@PathVariable("id") long id, Model model) {
        (new Dao()).delete(Product.class,(int) id);
        model.addAttribute("listProducts", (new Dao()).getAll(Product.class));
        model.addAttribute("IndexPageAddress","../../index.html");
        return "../../WEB-INF/jsp/products.jsp";
    }

    @RequestMapping(value = "/user/{id}/remove")
    public String removeUser(@PathVariable("id") long id, Model model) {
        (new Dao()).delete(User.class,(int) id);
        model.addAttribute("listUsers", (new Dao()).getAll(User.class));
        model.addAttribute("IndexPageAddress","../../index.html");
        return "../../WEB-INF/jsp/users.jsp";
    }
}