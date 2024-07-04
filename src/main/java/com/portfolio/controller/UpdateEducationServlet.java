package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.EducationServiceImpl;

@WebServlet("/UpdateEducationServlet")
public class UpdateEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sn = request.getParameter("sn");
		String year = request.getParameter("year");
		String school = request.getParameter("school");
		String section = request.getParameter("section");
		String description = request.getParameter("description");
		
		EducationServiceImpl educationServiceImpl = new EducationServiceImpl();
		String result = educationServiceImpl.UpdateEducationService(year, school, section, description, sn);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
	}

}
