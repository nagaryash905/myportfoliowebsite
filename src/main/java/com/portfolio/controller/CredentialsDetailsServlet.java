package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.CredentilasPojo;
import com.portfolio.service.LoginServiceImpl;

@WebServlet("/CredentialsDetailsServlet")
public class CredentialsDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		ArrayList<CredentilasPojo> arrayList = loginServiceImpl.readCredentilasService();
//		System.out.println("The array List on the credentials servlet is : "+arrayList);

		if(arrayList==null)
		{
			session.setAttribute("msg", "Something Went wrong on the Service Layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "Something Went wrong on the DAO Layer");
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
				session.setAttribute("contactdata",arrayList);
				response.sendRedirect("readcredential.jsp");
			}
		}
	}
		
}

