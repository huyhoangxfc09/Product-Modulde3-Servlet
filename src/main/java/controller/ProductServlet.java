package controller;

import model.Product;
import service.OptionService;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    private OptionService optionService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditFrom(request,response);
                break;
            case "delete":
                showDeleteFrom(request, response);
                break;
            case "view":
                viewProduct(request,response);
                break;
            default:
                listProducts(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                updateProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "search":
                searchProduct(request, response);
                break;
            default:
                break;
        }
    }

    private void searchProduct(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("search");
        Product product = this.optionService.findByName(name);
        RequestDispatcher dispatcher;
//        if (product != null){
//            request.setAttribute("product",product);
//            dispatcher = request.getRequestDispatcher("product/view.jsp");
//            try {
//                dispatcher.forward(request, response);
//            } catch (ServletException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
////            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        }else {
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//            dispatcher.forward(request, response);
//        }
        request.setAttribute("product",product);
        dispatcher = request.getRequestDispatcher("product/view.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void  listProducts(HttpServletRequest request, HttpServletResponse response){
            List<Product> products = this.productService.findAll();
            request.setAttribute("products", products);
            RequestDispatcher dispatcher =request.getRequestDispatcher("product/list.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void createProduct(HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String company = request.getParameter("company");

            Product product = new Product(id,name,price,description,company);
            this.productService.save(product);
            RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
            request.setAttribute("message","New product was created");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void showEditFrom(HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.findById(id);
            RequestDispatcher dispatcher;
            if (product == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }else {
                request.setAttribute("product", product);
                dispatcher = request.getRequestDispatcher("product/edit.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void updateProduct(HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            String description = request.getParameter("description");
            String company = request.getParameter("company");
            Product product = this.productService.findById(id);
            RequestDispatcher dispatcher;
            if (product == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }else {
                product.setName(name);
                product.setPrice(price);
                product.setDescription(description);
                product.setCompany(company);
                this.productService.update(id, product);
                request.setAttribute("product", product);
                request.setAttribute("message", "Product information war updated.");
                dispatcher = request.getRequestDispatcher("product/edit.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void showDeleteFrom(HttpServletRequest request, HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.findById(id);
            RequestDispatcher dispatcher;
            if(product == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            } else {
                request.setAttribute("product", product);
                dispatcher = request.getRequestDispatcher("product/delete.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void deleteProduct(HttpServletRequest request,HttpServletResponse response){
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.findById(id);
            RequestDispatcher dispatcher;
            if (product == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }else {
                this.productService.remove(id);
                try {
                    response.sendRedirect("/products");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void viewProduct(HttpServletRequest request, HttpServletResponse response){
            int id =Integer.parseInt(request.getParameter("id"));
            Product product = this.productService.findById(id);
            RequestDispatcher dispatcher;
            if (product == null){
                dispatcher = request.getRequestDispatcher("error-404.jsp");
            }else {
                request.setAttribute("product", product);
                dispatcher = request.getRequestDispatcher("product/view.jsp");
            }
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
