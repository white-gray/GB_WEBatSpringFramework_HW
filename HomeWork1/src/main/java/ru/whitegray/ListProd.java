package ru.whitegray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.whitegray.products.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListProd", urlPatterns = "/list_prods")
public class ListProd extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(SecondServlet.class);

    /**
     * создаеёт новое значение cost
     */
    private static float makeCost() {
        double doub = Math.random() * 10000;
        double scale = Math.pow(10, 2);
        double price = Math.ceil(doub * scale) / scale;
        return (float) price;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("\tGo list products");
        List<Product> products = new ArrayList<>();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        for (int q = 1; q < 10; q++) {
            products.add(new Product(q, "Product_" + q, makeCost()));
        }
        resp.getWriter().printf("<blockquote><h2>Сейчас есть:</h2>");
        resp.getWriter().printf("<blockquote><blockquote><table cellpadding='7' border='2' ><tr><th>id</th><th>title</th><th>cost, руб.</th></tr>");
        for (Product q : products) {
            resp.getWriter().printf("<tr><td>" + q.getId() + "</td><td>" + q.getTitle() + "</td><td>" + q.getCost() + "</td></tr>");
        }
        resp.getWriter().printf("</table></blockquote></blockquote></blockquote>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("New POST request");

        resp.getWriter().printf("<h1>New POST request</h1>");
    }


}

