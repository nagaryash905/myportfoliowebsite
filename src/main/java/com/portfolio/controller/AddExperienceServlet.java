package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.ExperienceServiceImpl;

@WebServlet("/AddExperienceServlet")
public class AddExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String jobtitle = request.getParameter("jobtitle");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		String result = experienceServiceImpl.insertExperienceService(year, jobtitle, company, description);
				
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
	}

}
