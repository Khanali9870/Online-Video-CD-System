package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.VcdDataImp;
import com.db.DbConnect;

@WebServlet("/delete_old_vcd")
public class DeleteOldVcd extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String em = req.getParameter("em");
			int id = Integer.parseInt(req.getParameter("id"));
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			boolean f = data.oldVcdDelete(em, "Old",id);
			HttpSession session = req.getSession();
			if (f) {
				session.setAttribute("SucessMagssage", "Old Vcd Delete Sucessfully...");
				resp.sendRedirect("old_vcd.jsp");

			} else {
				session.setAttribute("FailedMassage", "Something wrong on server");
				resp.sendRedirect("old_vcd.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
