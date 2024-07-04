package com.portfolio.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.portfolio.model.ProfilePojo;
import com.portfolio.service.ProfileServiceImpl;

@WebServlet("/ReadUpdateDeleteProfileServlet")
public class ReadUpdateDeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		ProfileServiceImpl profileServiceImpl = new ProfileServiceImpl();
		ArrayList<ProfilePojo> arrayList = profileServiceImpl.readProfileService();
		
		if(arrayList==null)
		{
			session.setAttribute("msg", "Error on Service layer");
			response.sendRedirect("adminpanel.jsp");
		}
		else if(arrayList.isEmpty())
		{
			session.setAttribute("msg", "Error on DAO layer");
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
				session.setAttribute("readprofile", arrayList);
				response.sendRedirect("readprofile.jsp");
			}
		}
	}

}
