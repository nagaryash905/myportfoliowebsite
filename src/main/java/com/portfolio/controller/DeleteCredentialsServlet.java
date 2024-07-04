package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.LoginServiceImpl;

@WebServlet("/DeleteCredentialsServlet")
public class DeleteCredentialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		String sn = request.getParameter("id"); 
		
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		String result = loginServiceImpl.deleteService(sn);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp"); 
	}

}
