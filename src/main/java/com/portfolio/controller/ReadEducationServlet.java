package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.dao.EducationDAOImpl;
import com.portfolio.model.EducationPojo;

@WebServlet("/ReadEducationServlet")
public class ReadEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String year = request.getParameter("year");
		String school = request.getParameter("school");
		String section = request.getParameter("section");
		String description = request.getParameter("description");

		// Get the data from the Service Layer
		EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
		ArrayList<EducationPojo> arrayList = educationDAOImpl.readEducationDAO();
		
		if (arrayList == null)
		{
			session.setAttribute("msg", "Error on Service Layer");
			response.sendRedirect("adminpanel.jsp");
		} 
		else if (arrayList.isEmpty()) 
		{
			session.setAttribute("msg", "Error on DAO Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else 
		{
			String year2 = arrayList.get(0).getYear();
			if (year2.equals("ne"))
			{
				session.setAttribute("msg", "Data Does Not Exist");
				response.sendRedirect("adminpanel.jsp");
			}
			else
			{
				session.setAttribute("readEducation", arrayList);
				response.sendRedirect("readeducation.jsp");
			}		
	}

  }
}
