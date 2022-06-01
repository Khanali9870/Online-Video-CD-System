package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DataAcc.UserData;
import com.DataAcc.UserDataImp;
import com.db.DbConnect;
import com.entity.User;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDataImp data = new UserDataImp(DbConnect.getConnection());
			HttpSession session = req.getSession();
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			if ("admin@gmail.com".equals(email) && "admin".equals(password)) {
				User user = new User();
				user.setName("Admin");
				session.setAttribute("userobj", user);
				resp.sendRedirect("admin/home.jsp");
			} else {
				User user = data.login(email, password);
				if (user != null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("index.jsp");

				} else {
					session.setAttribute("failedMsg", "Email & Password Invalid");
					resp.sendRedirect("login.jsp");
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
