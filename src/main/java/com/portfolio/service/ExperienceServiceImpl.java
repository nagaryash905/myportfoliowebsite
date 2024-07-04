package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.dao.ExperienceDAOImpl;
import com.portfolio.model.ExperiencePojo;

public class ExperienceServiceImpl implements ExperienceService {

	private String result;
	@Override
	public String insertExperienceService(String year, String jobtitle, String company, String description) {
		try 
		{
			ExperienceDAOImpl experienceDAOImpl = new ExperienceDAOImpl();
			result=experienceDAOImpl.insertExperienceDAO(year, jobtitle, company, description);
		}
		catch (Exception e)
		{
			result="Error while insert the Experience Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ExperiencePojo> readExperienceService() {
		
		ArrayList<ExperiencePojo> arrayList = null;
		try 
		{
			ExperienceDAOImpl experienceDAOImpl = new ExperienceDAOImpl();
			arrayList=experienceDAOImpl.readExperienceDAO();
		}
		catch (Exception e)
		{
			result="Error while Read the Experience Service Layer";
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public String deleteServiceExperience(String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ExperienceDAOImpl experienceDAOImpl = new ExperienceDAOImpl();
			result=experienceDAOImpl.deleteExperience(intsn);
		}
		catch (Exception e)
		{
			result="Error while Delete the Experience Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateExperience(String year, String jobtitle, String company, String description, String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ExperienceDAOImpl experienceDAOImpl = new ExperienceDAOImpl();
			result=experienceDAOImpl.updateExperience(year, jobtitle, company, description, intsn);
		}
		catch (Exception e)
		{
			result="Error while Update the Experience Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	

}
