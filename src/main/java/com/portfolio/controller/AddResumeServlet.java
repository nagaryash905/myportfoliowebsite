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
import com.portfolio.service.UploadResumeServiceImpl;

@WebServlet("/AddResumeServlet")
@MultipartConfig
public class AddResumeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Part part = request.getPart("myresume");
		
		UploadResumeServiceImpl uploadResumeServiceImpl = new UploadResumeServiceImpl();
		String result = uploadResumeServiceImpl.uploadResumeService(part);
		
		session.setAttribute("msg", result);
		response.sendRedirect("adminpanel.jsp");
	}

}
