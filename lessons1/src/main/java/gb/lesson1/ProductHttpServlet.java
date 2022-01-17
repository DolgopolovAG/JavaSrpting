package gb.lesson1;

import gb.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "ProductHttpServlet", urlPatterns = "/product")
public class ProductHttpServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductHttpServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       logger.info("My Get request");

       //resp.setHeader("Content-Type", "text/html; character=utf-8");
       // resp.getWriter().printf("<h1>New Get</h1>");
       //getServletContext().getRequestDispatcher("/prod_lesson1").forward(req,resp);

        req.setAttribute("product",getProducts());
        getServletContext().getRequestDispatcher("/product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().printf("<h1>New Post</h1>");
    }

    private List<Product> getProducts(){
        List<Product> prods = Arrays.asList(
                new Product(1,"Продукт 1", 4),
                new Product(2,"Продукт 2", 5),
                new Product(3,"Продукт 3", 6),
                new Product(4,"Продукт 4", 7),
                new Product(5,"Продукт 5", 8),
                new Product(6,"Продукт 6", 9),
                new Product(7,"Продукт 7", 10),
                new Product(8,"Продукт 8", 11),
                new Product(9,"Продукт 9", 12),
                new Product(10,"Продукт 10", 13)
        );
        return prods;
    }
}
