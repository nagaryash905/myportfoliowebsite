package com.portfolio.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DownloadResumeServlet")
public class DownloadResumeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String path = "D:\\New Portfolio Wesite\\Yash@Portfoilo\\Yash__Portfolio\\src\\main\\webapp\\resume\\YashNagarResume.pdf";
        
        FileInputStream fileInputStream = new FileInputStream(path);
        
		byte b[] = new byte[fileInputStream.available()];
		
		fileInputStream.read(b);
        
        ServletOutputStream outputStream = response.getOutputStream();
        
        response.setHeader("Content-Disposition", "attachment; filename=Yash_Nagar.pdf");
        response.setContentType("application/octet-stream");
        
        outputStream.write(b);
        
        fileInputStream.close();
        outputStream.close();
    }
}


