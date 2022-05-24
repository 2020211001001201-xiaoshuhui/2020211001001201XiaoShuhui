package com.XiaoShuhui.controller;

import com.XiaoShuhui.dao.OrderDao;
import com.XiaoShuhui.model.Item;
import com.XiaoShuhui.model.Order;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet", value = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con=(Connection)getServletContext().getAttribute("con");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    int orderId=request.getParameter("orderId")!=null?Integer.parseInt(request.getParameter("orderId")):0;
    Item item=new Item();
    OrderDao orderDao=new OrderDao();
    List<Item> items=orderDao.findItemsByOrderId(con,orderId);
    //Log.info(items.toString());
        request.setAttribute("itemList",items);
        String path="orderDetails.jsp";
        //Log.info(path);
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }
}
