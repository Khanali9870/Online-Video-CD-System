package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.CartDataImp;
import com.db.DbConnect;

@WebServlet("/remove_vcd")
public class RemoveVcdCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int vid = Integer.parseInt(req.getParameter("vid"));
		int uid = Integer.parseInt(req.getParameter("uid"));
		int cid= Integer.parseInt(req.getParameter("cid"));
		CartDataImp data = new CartDataImp(DbConnect.getConnection());
		boolean f = data.deteteVcd(vid,uid,cid);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("SucessMagssage", "Vcd Removed from cart");
			resp.sendRedirect("checkout.jsp");

		}
		else {
			session.setAttribute("FailedMassage", "Something wrong on server");
			resp.sendRedirect("checkout.jsp");
		}
	}

}
