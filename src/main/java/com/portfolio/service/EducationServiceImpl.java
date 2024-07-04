package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.dao.EducationDAOImpl;
import com.portfolio.dao.LoginDAOImpl;
import com.portfolio.model.EducationPojo;

public class EducationServiceImpl implements EducationService {

	private String result;
	@Override
	public String insertEducationService(String year, String school, String section, String description) {
		try 
		{
			//Get the Data From the DAO Layer
			EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
			result=educationDAOImpl.insertEducationDAO(year, school, section, description);
		}
		catch (Exception e) 
		{
			result="Error on Service Layer while insert Education";
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public ArrayList<EducationPojo> readEducationService() {
		
		ArrayList<EducationPojo> arrayList=null;
		try 
		{
			//Get the Data From the DAO
			EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
			arrayList=educationDAOImpl.readEducationDAO();
		}
		catch (Exception e)
		{
			result="Error on the Education Service While Read";
			e.printStackTrace();
		}
		return arrayList;
	}


	@Override
	public String deleteServiceEducation(String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
			result=educationDAOImpl.deleteEducation(intsn);
		} 
		catch (Exception e)
		{
			result = "Something went wrong on the Delete Education Service Erro on Service Layer";
			e.printStackTrace();
		}

		return result;
	}


	@Override
	public String UpdateEducationService(String year, String school, String section, String description, String sn) {
		try
		{
			int intsn = Integer.parseInt(sn);
			EducationDAOImpl educationDAOImpl = new EducationDAOImpl();
			result=educationDAOImpl.UpdateEducation(year, school, section, description, intsn);
		} 
		catch (Exception e) 
		{
			result = "Something went wrong on the Update Education Service Erro on Service Layer";
			e.printStackTrace();
		}

		return result;
	}

}
