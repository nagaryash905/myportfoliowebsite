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

@WebServlet("/IndexEducationServlet")
public class IndexEducationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
		ArrayList<EducationPojo> arrayList = educationDAOImpl.readEducationDAO();
		session.setAttribute("checkedu", "FROMSERVLET");
		
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
				session.setAttribute("education", arrayList);
				response.sendRedirect("index.jsp");
			}		
	}
	}

}
