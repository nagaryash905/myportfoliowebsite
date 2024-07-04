package com.portfolio.service;

import com.portfolio.dao.SignupDAOImpl;

public class SignupServiceImpl implements SignupService {

	private String result;
	@Override
	public String signupService(String name, String email, String password) {
		
		try 
		{
			SignupDAOImpl signupDAOImpl = new SignupDAOImpl();
			result=signupDAOImpl.SignupDao(name, email, password);
		} 
		catch (Exception e)
		{
			result="Something Went Wrong on the SignUp Service Impl Class";
		}
		return result;
	}

}
