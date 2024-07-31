package org.example.demoviewc04.controller;

import org.example.demoviewc04.model.Product;
import org.example.demoviewc04.service.product.IProductService;
import org.example.demoviewc04.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "productController", value = "/products")
public class ProductController extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "edit":
                showFormEdit(req, resp);
                break;
            default:
                List<Product> products = productService.findAll();
                req.setAttribute("products", products);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/product/list.jsp");
                dispatcher.forward(req, resp);
        }

    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("index");
        int index= Integer.parseInt(id);
        Product product = productService.findById(index);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/product/edit.jsp");
        req.setAttribute("product", product);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int index = Integer.parseInt(req.getParameter("index"));
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        Product product = new Product(id, name, price);
        productService.update(index, product);
        resp.sendRedirect(req.getContextPath() + "/products");
    }
}
