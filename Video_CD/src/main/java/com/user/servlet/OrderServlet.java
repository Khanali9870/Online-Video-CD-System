package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.CartDataImp;
import com.DataAcc.VcdOrderImp;
import com.db.DbConnect;
import com.entity.Cart;
import com.entity.Vcd_order;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession session=req.getSession();
			
			int id=Integer.parseInt(req.getParameter("id"));
			String name=req.getParameter("username");
			
			String email=req.getParameter("email");
			String phoneno=req.getParameter("phoneno");
			String address=req.getParameter("address");
			String landmark=req.getParameter("landmark");
			String city=req.getParameter("city");
			String state=req.getParameter("state");
			String pincode=req.getParameter("pincode");
			String paymentType=req.getParameter("payment");
			
			String fullAddress=address+","+landmark+","+city+","+state+","+pincode;
			
			CartDataImp data=new CartDataImp(DbConnect.getConnection());
			List<Cart> list=data.getVcdByUser(id);
			
			if(list.isEmpty())
			{
				session.setAttribute("FailedMassage", "Add Item");
				resp.sendRedirect("checkout.jsp");
				
			}else {
				VcdOrderImp data2=new VcdOrderImp(DbConnect.getConnection());
				
				
				Vcd_order order=null;
				
				ArrayList<Vcd_order> orderList=new ArrayList<Vcd_order>();
				Random random=new Random();
				for(Cart c:list)
				{
					order=new Vcd_order();
					order.setOrderId("VCD-ORD-00"+random.nextInt(1000));
					order.setUserName(name);
					order.setEmail(email);
					order.setPhoneno(phoneno);
					order.setFullAdd(fullAddress);
					order.setVcdName(c.getVcdName());
					order.setActors(c.getActors());
					order.setPrice(c.getPrice()+"");
					order.setPaymentType(paymentType);
					orderList.add(order);
					
				}
				
				if("noselect".equals(paymentType))
				{
					session.setAttribute("FailedMassage", "Please Choose Payment Method");
					resp.sendRedirect("checkout.jsp");
				}else {
					boolean f=data2.saveOrder(orderList);
					if(f) {
						resp.sendRedirect("order_success.jsp");
					}
					else {
						session.setAttribute("FailedMassage", "Your Order Failed");
						resp.sendRedirect("checkout.jsp");
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
