package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.service.ProjectServiceImpl;

@WebServlet("/UploadProjectServlet")
public class UploadProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String project = request.getParameter("project");
		String description = request.getParameter("description");
		
		ProjectServiceImpl projectServiceImpl = new ProjectServiceImpl();
		String result = projectServiceImpl.insertProjectService(project, description);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
	}

}
