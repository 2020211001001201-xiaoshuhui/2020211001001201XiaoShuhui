package com.XiaoShuhui.controller;

import com.XiaoShuhui.dao.ProductDao;
import com.XiaoShuhui.model.Category;
import com.XiaoShuhui.model.Product;

import javax.servlet.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
@MultipartConfig(maxFileSize = 16177215)
public class AddProductServlet extends HttpServlet {
    Connection con=null;
    public void init(){
        con=(Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Category> categoryList= Category.findAllCategory(con);
    request.setAttribute("categoryList",categoryList);
    String path="/WEB-INF/views/admin/addProduct.jsp";
    request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//get parameters
        String productName=request.getParameter("productName");
        Double price=request.getParameter("price")!=null?Double.parseDouble(request.getParameter("price")):0.0;
        int categoryId=request.getParameter("categoryId")!=null?Integer.parseInt(request.getParameter("categoryId")):0;
        String productDescription=request.getParameter("productDescription");
        //picture
        InputStream inputStream=null;
        Part fileParts=request.getPart("picture");
        if(fileParts!=null){
            //System.out.println("file name :"+filepart.getName()+"size"+filepart.getSize()+"file type"+filepart.getContentType());
            inputStream= fileParts.getInputStream();
        }
        //set in model
        Product product=new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setPicture(inputStream);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);
//call same in dao
        ProductDao productDao= new ProductDao();
        int i=0;
        try {
            i=productDao.save(product,con);
            if(i>0) {
                response.sendRedirect("productList");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
