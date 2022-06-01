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

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String name = req.getParameter("fname");
			String email=req.getParameter("email");
			String phoneno=req.getParameter("phoneno");
			String password=req.getParameter("password");
			String check=req.getParameter("check");
			//System.out.println(name+" "+email+" "+phoneno+" "+password+" "+check);
			User user=new User();
			user.setName(name);
			user.setEmail(email);
			user.setPhoneno(phoneno);
			user.setPassword(password);
			HttpSession session=req.getSession();
			if(check!=null)
			{
				UserDataImp dataImp=new UserDataImp(DbConnect.getConnection());
				
				boolean f2=dataImp.checkUser(email);
				if(f2)
				{
					boolean f=dataImp.userRegister(user);
					if(f) {
						//System.out.println("User Register Success...");
						session.setAttribute("SucessMagssage"," Registration Sucessfully..");
						resp.sendRedirect("Register.jsp");
					}
					else {
						//System.out.println("Something wrong on server...");
						session.setAttribute("FailedMassage"," Something wrong on server...");
						resp.sendRedirect("Register.jsp");
					}
					
				}else {
					session.setAttribute("FailedMassage","User Already Exist  Try Another Email Id...");
					resp.sendRedirect("Register.jsp");
					
				}
			}
			else {
				//System.out.println("Please Check Agree & Term Condition");
				session.setAttribute("FailedMassage","Please Check Agree & Term Condition ");
				resp.sendRedirect("Register.jsp");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
