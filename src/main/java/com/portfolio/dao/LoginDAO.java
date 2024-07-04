package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.CredentilasPojo;

public interface LoginDAO {

    public String loginDao(String email, String password);
	
	public ArrayList<CredentilasPojo> readCredentialsDAO();

	public String delete(int sn);
}
