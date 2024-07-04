package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.portfolio.service.ContactServiceImpl;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		//Get Data From the Service Layer
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		String result = contactServiceImpl.insertContactService(name, email, message);
		
		session.setAttribute("msg", result);
		response.sendRedirect("index.jsp");
		
		
	}

}
