package com.portfolio.dao;

import java.util.ArrayList;

import com.portfolio.model.ContactPojo;

public interface ContactDao {
	
	public String insertContactDAO(String name, String email, String message, String datetime);
	
	public ArrayList<ContactPojo> readContactDAO();
	
	public String deleteContact(String sn);
	
}
