package com.XiaoShuhui.controller;

import com.XiaoShuhui.dao.ProductDao;
import com.XiaoShuhui.model.Category;
import com.XiaoShuhui.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Locale;

public class ShopServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Category category=new Category();
        List<Category> categoryList=Category.findAllCategory(con);
        request.setAttribute("categoryList",categoryList);

        ProductDao productDao= new ProductDao();
        try{
            if(request.getParameter("categoryId")==null) {
                //show all product
                List<Product> productList = productDao.findAll(con);
                request.setAttribute("productList", productList);
            }else {
                //show only one type of product
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productList =productDao.findByCategoryId(catId,con);
                request.setAttribute("productList", productList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String path="/WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
