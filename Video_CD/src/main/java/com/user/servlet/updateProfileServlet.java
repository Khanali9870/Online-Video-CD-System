package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.UserDataImp;
import com.db.DbConnect;
import com.entity.User;
@WebServlet("/update_profile")
public class updateProfileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id= Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email=req.getParameter("email");
			String phoneno=req.getParameter("phoneno");
			String password=req.getParameter("password");
			
			User us=new User();
			us.setId(id);
			us.setName(name);
			us.setEmail(email);
			us.setPhoneno(phoneno);
			
			HttpSession session=req.getSession();
			UserDataImp data=new UserDataImp(DbConnect.getConnection());
			boolean f=data.checkPassword(id, password);
			if(f) {
				boolean f2=data.updateProfile(us);
				if(f2)
				{
					session.setAttribute("SucessMagssage","User Profile Update Sucessfully..");
					resp.sendRedirect("edit_profile.jsp");	
				}
				else {
					session.setAttribute("failedMsg"," Something wrong on server..");
					resp.sendRedirect("edit_profile.jsp");
				}
			}else {
				session.setAttribute("failedMsg","Your Password is Incorrect");
				resp.sendRedirect("edit_profile.jsp");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	

}
