package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.CredentilasPojo;

public interface LoginService {
	
	public String loginService(String email, String password);
	
	public ArrayList<CredentilasPojo> readCredentilasService();
	
	public String deleteService(String sn);

	

}
