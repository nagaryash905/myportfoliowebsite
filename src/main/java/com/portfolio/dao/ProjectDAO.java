package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.ProjectPojo;

public interface ProjectDAO {
	
	public String insertProjectDAO(String project, String description);
	
	public ArrayList<ProjectPojo> readProjectDAO();
	
	public String deleteProjectDAO(int sn);
	
	public String updateProjectDAO(String project,String description, int sn);

}
