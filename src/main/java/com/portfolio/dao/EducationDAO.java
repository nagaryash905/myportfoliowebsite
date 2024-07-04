package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.EducationPojo;

public interface EducationDAO {
	
	public String insertEducationDAO(String year, String school, String section, String description);
	
	public ArrayList<EducationPojo> readEducationDAO();
	
	public String deleteEducation(int sn);
	
	public String UpdateEducation(String year, String school, String section, String description, int sn);

}
