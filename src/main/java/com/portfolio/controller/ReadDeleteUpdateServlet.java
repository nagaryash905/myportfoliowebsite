package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.ExperiencePojo;
import com.portfolio.service.ExperienceServiceImpl;

@WebServlet("/ReadDeleteUpdateServlet")
public class ReadDeleteUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String jobtitle = request.getParameter("jobtitle");
		String company = request.getParameter("company");
		String description = request.getParameter("description");
		
		ExperienceServiceImpl experienceServiceImpl = new ExperienceServiceImpl();
		ArrayList<ExperiencePojo> arrayList = experienceServiceImpl.readExperienceService();
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "Error on Experience service Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "Error on Experience DAO Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else
		{
			String year1 = arrayList.get(0).getYear();
			if(year1.equals("ne"))
			{
				session.setAttribute("msg", "Data Does Not Exist");
				response.sendRedirect("adminpanel.jsp");
			}
			else
			{
				session.setAttribute("readexperience", arrayList);
				response.sendRedirect("readexperience.jsp");
			}
		}
	}

}
