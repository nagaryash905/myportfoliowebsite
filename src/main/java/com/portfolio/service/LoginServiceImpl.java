package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.dao.LoginDAOImpl;
import com.portfolio.model.CredentilasPojo;

public class LoginServiceImpl implements LoginService {
	private String result;

	@Override
	public String loginService(String email, String password) {

		try {
			LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
			result = loginDAOImpl.loginDao(email, password);
		} catch (Exception e) {
			result = "Something Went Wrong on the Login Service Impl Class";
			e.printStackTrace();
		}
		return result;
	}

	// This method is to read All the credentials on the JSP page
	@Override
	public ArrayList<CredentilasPojo> readCredentilasService() {

		ArrayList<CredentilasPojo> arrayList = null;

		try {
			LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
			arrayList = loginDAOImpl.readCredentialsDAO();
		} catch (Exception e) {
			e.printStackTrace();
			result = "Something Went Wrong while read the credentilas from the Database.";
		}
		return arrayList;
	}

	@Override
	public String deleteService(String sn) {

		try {
			int intsn = Integer.parseInt(sn);
			LoginDAOImpl loginDAOImpl = new LoginDAOImpl();
			result = loginDAOImpl.delete(intsn);
		} catch (Exception e) {
			result = "Something went wrong on the Delete Service Erro on Service Layer";
			e.printStackTrace();
		}

		return result;
	}

}
