package com.XiaoShuhui.controller;

import com.XiaoShuhui.dao.ProductDao;
import com.XiaoShuhui.model.Category;
import com.XiaoShuhui.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

public class ProductDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList=Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);
        //get product by id
        if(request.getParameter("id")!=null) {
            int productId=Integer.  parseInt(request.getParameter("id"));
            ProductDao productDao = new ProductDao();
            Product product = productDao.findById(productId, con);
            request.setAttribute("p",product);
        }
        String path="/WEB-INF/views/productDetails.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
