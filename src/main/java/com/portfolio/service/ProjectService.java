package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.ProjectPojo;

public interface ProjectService {
	
	public String insertProjectService(String project, String description);
	
	public ArrayList<ProjectPojo> readProjectService();
	
	public String deleteService(String sn);
	
	public String updateprojectService(String project, String description,String sn);

}
