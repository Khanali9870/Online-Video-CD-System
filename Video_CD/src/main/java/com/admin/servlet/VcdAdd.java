package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DataAcc.VcdDataImp;
import com.db.DbConnect;
import com.entity.VcdDetails;

@WebServlet("/add_vcd")
@MultipartConfig
public class VcdAdd extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String vcdName = req.getParameter("vname");
			String actors = req.getParameter("actors");
			String price = req.getParameter("price");
			String catogories = req.getParameter("categories");
			String status = req.getParameter("status");
			Part part = req.getPart("vimg");
			String fileName = part.getSubmittedFileName();

			VcdDetails v = new VcdDetails(vcdName, actors, price, catogories, status, fileName, "admin");
			VcdDataImp data = new VcdDataImp(DbConnect.getConnection());

			boolean f = data.addVcd(v);
			HttpSession session = req.getSession();
			if (f) {
				String path=getServletContext().getRealPath("")+"Movies";	
				File file=new File(path);
				part.write(path + File.separator + fileName);

				session.setAttribute("SucessMagssage", "VCD Add Sucessfully...");
				resp.sendRedirect("admin/add_vcd.jsp");
			} else {
				session.setAttribute("FailedMassage", "Something wrong on Server");
				resp.sendRedirect("admin/add_vcd.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
