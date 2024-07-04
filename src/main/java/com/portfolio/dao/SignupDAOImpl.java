package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SignupDAOImpl implements SignupDAO {

	private String result;
	@Override
	public String SignupDao(String name, String email, String password) {
		
		try 
		{
			Connection connection = ConnectionFactory.getConnection();
			String sql="insert into signup(name,email,password) values(?,?,?)";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, email);
			prepareStatement.setString(3, password);
			
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Data Inserted Successfully";
			}
			else
			{
				result="Something Went Wrong On SignUp DAO Layer";
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			result="Something Went Wrong On SignUp DAO Layer";
		}
		return result;
	}


}
