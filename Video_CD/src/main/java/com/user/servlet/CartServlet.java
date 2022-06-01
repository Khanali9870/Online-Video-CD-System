package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.CartDataImp;
import com.DataAcc.VcdDataImp;
import com.db.DbConnect;
import com.entity.Cart;
import com.entity.VcdDetails;

@WebServlet("/cart")
public class CartServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int vid=Integer.parseInt(req.getParameter("vid"));
			int uid=Integer.parseInt(req.getParameter("uid"));
			
			VcdDataImp data=new VcdDataImp(DbConnect.getConnection());
			VcdDetails v=data.getVcdById(vid);
			
			Cart cart=new Cart();
			cart.setVid(vid);
			cart.setUserid(uid);
			cart.setVcdName(v.getVcdName());			
			cart.setActors(v.getActors());
			cart.setPrice(Double.parseDouble(v.getPrice()));
			cart.setTotalPrice(Double.parseDouble(v.getPrice()));
			
			CartDataImp data2=new CartDataImp(DbConnect.getConnection());
			boolean f=data2.addCart(cart);
			HttpSession session=req.getSession();
			if(f)
			{
				session.setAttribute("addCart", "Vcd Added to cart");
				resp.sendRedirect("all_new_vcd.jsp");
			}else {
				session.setAttribute("failed", "Something wrong on server..");
				resp.sendRedirect("all_new_vcd.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
