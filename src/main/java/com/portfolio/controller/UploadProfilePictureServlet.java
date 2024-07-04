package com.portfolio.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.portfolio.service.ProfilePictureServiceImpl;

@WebServlet("/UploadProfilePictureServlet")
@MultipartConfig
public class UploadProfilePictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Part part = request.getPart("mypicture");
		
		ProfilePictureServiceImpl profilePictureServiceImpl = new ProfilePictureServiceImpl();
		String result = profilePictureServiceImpl.uploadProfilePicture(part);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");

	}

}
