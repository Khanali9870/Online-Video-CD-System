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
import com.entity.VcdDetails;

@WebServlet("/editvcd")
public class EditvcdServalet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String vcdName = req.getParameter("vname");
			String actors = req.getParameter("actors");
			String price = req.getParameter("price");
			String status = req.getParameter("status");
			
			VcdDetails v=new VcdDetails();
			v.setVcdId(id);
			v.setVcdName(vcdName);
			v.setActors(actors);
			v.setPrice(price);
			v.setStatus(status);
			
			VcdDataImp data= new VcdDataImp(DbConnect.getConnection());
			boolean f=data.updateEditvcd(v);
			
			HttpSession session=req.getSession();
			
			if(f) {
				session.setAttribute("SucessMagssage", "VCD Update Sucessfully..");
				resp.sendRedirect("admin/all_vcd.jsp");
			}else {
				session.setAttribute("FailedMassage", "Something wrong in server...");
				resp.sendRedirect("admin/all_vcd.jsp");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
