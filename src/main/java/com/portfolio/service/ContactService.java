package com.portfolio.service;

import java.util.ArrayList;

import com.portfolio.model.ContactPojo;

public interface ContactService {
	
	public String insertContactService(String name, String email, String message);
	
	public ArrayList<ContactPojo> readContactService();
	
	public  String deleteContact(String sn);

}
