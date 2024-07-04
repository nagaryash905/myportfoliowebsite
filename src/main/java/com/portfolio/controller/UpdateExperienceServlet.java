package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.ExperienceServiceImpl;

@WebServlet("/UpdateExperienceServlet")
public class UpdateExperienceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sn = request.getParameter("sn");
		String year = request.getParameter("year");
		String jobtitle = request.getParameter("jobtitle");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		String result = experienceServiceImpl.updateExperience(year, jobtitle, company, description, sn);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
			
	}

}
