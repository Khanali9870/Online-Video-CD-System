package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.VcdDataImp;
import com.db.DbConnect;

@WebServlet("/delete")
public class VcdDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());
			boolean f = data.deleteVcd(id);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("SucessMagssage", "VCD Delete Sucessfully..");
				resp.sendRedirect("admin/all_vcd.jsp");
			} else {
				session.setAttribute("FailedMassage", "Something wrong in server...");
				resp.sendRedirect("admin/all_vcd.jsp");

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
