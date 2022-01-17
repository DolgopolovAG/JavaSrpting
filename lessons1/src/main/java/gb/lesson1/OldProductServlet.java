package gb.lesson1;

import gb.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class OldProductServlet implements Servlet {

    private static Logger logger = LoggerFactory.getLogger(Product.class);

    private transient ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
    }

    @Override
    public String getServletInfo() {
        return "ProductServlet";
    }

    @Override
    public void destroy() {
        logger.info("Destroyed {}", getServletInfo());
    }
}
