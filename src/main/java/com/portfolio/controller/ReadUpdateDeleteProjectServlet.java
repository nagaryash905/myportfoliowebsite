package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.ProjectPojo;
import com.portfolio.service.ProjectServiceImpl;

@WebServlet("/ReadUpdateDeleteProjectServlet")
public class ReadUpdateDeleteProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("check", "FROMSERVLET");
		/*
		 * String project = request.getParameter("project"); String description =
		 * request.getParameter("description");
		 */
		ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
		ArrayList<ProjectPojo> arrayList = projectServiceImpl.readProjectService();
	
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "Error On Service Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "Error On DAO Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else
		{
			String proj = arrayList.get(0).getProject();
			 if(proj.equals("ne"))
			 {
				 session.setAttribute("msg", "Data Does not Exist");
				 response.sendRedirect("adminpanel.jsp");
			 }
			 else
			 {
				 session.setAttribute("readproject", arrayList);
				 response.sendRedirect("readproject.jsp");
//				 response.sendRedirect("index.jsp");
			 }
		}
		
	}

}
