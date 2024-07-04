package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.EducationPojo;
import com.portfolio.model.ExperiencePojo;

public interface ExperienceService {
	
public String insertExperienceService(String year, String jobtitle, String company,String description);
	
	public ArrayList<ExperiencePojo> readExperienceService();
	
	public String deleteServiceExperience(String sn);
	
	public String updateExperience(String year, String jobtitle, String company, String description, String sn);


}
