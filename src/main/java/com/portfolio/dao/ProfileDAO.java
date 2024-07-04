package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.ProfilePojo;

public interface ProfileDAO {

	public String inserProfileDAO(String name, String designation, String description);
	
	public ArrayList<ProfilePojo> readProfileDAO();
	
	public String deleteProfileDAO(int sn);

	public String updateProfileDAO(String name, String designation, String description, int sn);
}
