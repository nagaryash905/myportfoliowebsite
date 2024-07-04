package com.portfolio.service;

import java.time.LocalDateTime;
import java.util.ArrayList;

import com.portfolio.dao.ContactDaoImpl;
import com.portfolio.model.ContactPojo;

public class ContactServiceImpl implements ContactService {

	private String result;
	@Override
	public String insertContactService(String name, String email, String message) {
		try 
		{
			//Get Data From the DAO Layer
			String datetime = LocalDateTime.now().toString();
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result=contactDaoImpl.insertContactDAO(name, email, message,datetime);
		} 
		catch (Exception e) 
		{
			result="Service Error While Send Message";
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public ArrayList<ContactPojo> readContactService() {
		
		ArrayList<ContactPojo> arrayList =null;
		try 
		{
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			arrayList=contactDaoImpl.readContactDAO();
		} 
		catch (Exception e)
		{
			result="Error on Service Layer while Read Contact";
			e.printStackTrace();
		}
		
		return arrayList;
	}

	@Override
	public String deleteContact(String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ContactDaoImpl contactDaoImpl = new ContactDaoImpl();
			result=contactDaoImpl.deleteContact(sn);
		}
		catch (Exception e) 
		{
			result="Error While Deleting Delete Contact";
			e.printStackTrace();
		}
		
		return result;
	}

}
