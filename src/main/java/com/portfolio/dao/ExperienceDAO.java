package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.ExperiencePojo;

public interface ExperienceDAO {

public String insertExperienceDAO(String year, String jobtitle, String company, String description);
	
	public ArrayList<ExperiencePojo> readExperienceDAO();
	
	public String deleteExperience(int sn);
	
	public String updateExperience(String year, String jobtitle, String company, String description, int sn);
}
