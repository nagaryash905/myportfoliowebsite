package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.EducationPojo;

public interface EducationService {
	
	public String insertEducationService(String year, String school, String section,String description);
	
	public ArrayList<EducationPojo> readEducationService();
	
	public String deleteServiceEducation(String sn);
	
	public String UpdateEducationService(String year, String school, String section,String description, String sn);

}
