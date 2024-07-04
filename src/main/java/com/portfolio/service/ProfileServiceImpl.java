package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.dao.ProfileDAOImpl;
import com.portfolio.model.ProfilePojo;

public class ProfileServiceImpl implements ProfileService {

	private String result;
	@Override
	public String inserProfileService(String name, String designation, String description) {
		try 
		{
			ProfileDAOImpl profileDAOImpl = new ProfileDAOImpl();
			result=profileDAOImpl.inserProfileDAO(name, designation, description);
		} 
		catch (Exception e) 
		{
			result="Error While Insert Profile On Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ProfilePojo> readProfileService() {
		
		ArrayList<ProfilePojo> arrayList = null;
		try
		{
			ProfileDAOImpl profileDAOImpl = new ProfileDAOImpl();
			arrayList=profileDAOImpl.readProfileDAO();
		}
		catch (Exception e) 
		{
			result="Error While Read Profile On Service Layer";
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public String deleteProfileService(String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ProfileDAOImpl profileDAOImpl = new ProfileDAOImpl();
			result=profileDAOImpl.deleteProfileDAO(intsn);
		}
		catch (Exception e) 
		{
			result="Error While Delete Profile On Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateProfileService(String name, String designation, String description,String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ProfileDAOImpl profileDAOImpl = new ProfileDAOImpl();
			result=profileDAOImpl.updateProfileDAO(name, designation, description, intsn);
		}
		catch (Exception e) 
		{
			result="Error While Update Profile On Service Layer";
			e.printStackTrace();
		}
		return result;
	}

}
