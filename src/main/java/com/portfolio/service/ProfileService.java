package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.ProfilePojo;

public interface ProfileService {

public String inserProfileService(String name, String designation, String description);
	
	public ArrayList<ProfilePojo> readProfileService();
	
	public String deleteProfileService(String sn);
	
	public String updateProfileService(String name, String designation, String description,String sn);
}
