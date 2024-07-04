package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.LoginServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		String result = loginServiceImpl.loginService(email, password);
//		System.out.println("The result on the Login Servlet is : "+result);
		
		if(result.equals("Exist"))
		{
			session.setAttribute("admin", email);
			response.sendRedirect("adminpanel.jsp");
		}
	}

}
