package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.ContactPojo;
import com.portfolio.service.ContactServiceImpl;

@WebServlet("/ReadMessageServlet")
public class ReadMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ContactServiceImpl contactServiceImpl = new ContactServiceImpl();
		ArrayList<ContactPojo> arrayList = contactServiceImpl.readContactService();
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "Something Went Wrong on the Service Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "Something Went Wrong on the DAO Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else
		{
			String name = arrayList.get(0).getName();
			if(name.equals("ne"))
			{
				session.setAttribute("msg", "Data Does Not Exist");
				response.sendRedirect("adminpanel.jsp");
			}
			else
			{
				session.setAttribute("readcontact", arrayList);
				response.sendRedirect("contact.jsp");
			}
		}
		
	}

}
