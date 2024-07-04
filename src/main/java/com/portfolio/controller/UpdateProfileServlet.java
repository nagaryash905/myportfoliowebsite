package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.ProfileServiceImpl;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sn = request.getParameter("sn");
		String name = request.getParameter("name");
		String designation = request.getParameter("designation");
		String description = request.getParameter("description");

		ProfileServiceImpl profileServiceImpl = new ProfileServiceImpl();
		String result = profileServiceImpl.updateProfileService(name, designation, description, sn);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
		

}

}
