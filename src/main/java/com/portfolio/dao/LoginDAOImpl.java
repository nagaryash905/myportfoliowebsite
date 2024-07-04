package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.model.CredentilasPojo;

public class LoginDAOImpl implements LoginDAO {

	private String result;
	private Connection connection;
	
	//This method is for Read the Credentials from the table 
	@Override
	public String loginDao(String email, String password) {
		
		try 
		{
			connection = ConnectionFactory.getConnection();
			String sql="select * from signup";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(rs.next())
			{
				result="Exist";
			}
			else
			{
				result="Not Exist";
			}
		}
		catch (Exception e)
		{
			result="Something Wrong on DAO : LoginDao Method";
			e.printStackTrace();
		}
		return result;
	}
	
	
	//This method is used to read all the Data from the Database and show on the JSP Page
	@Override
	public ArrayList<CredentilasPojo> readCredentialsDAO() {
		
		ArrayList<CredentilasPojo> arrayList = new ArrayList<CredentilasPojo>();
		
		try 
		{
			connection = ConnectionFactory.getConnection();
			String sql="select * from signup";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet rs = prepareStatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new CredentilasPojo(0,"ne","ne","ne"));
			}
			else
			{
				do
				{
					arrayList.add(new CredentilasPojo(rs.getInt("sn"), rs.getString("name"),
							rs.getString("email"), rs.getString("password")));
				}
				while(rs.next());
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			arrayList.clear();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return arrayList;
	}


	@Override
	public String delete(int sn) {
		
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from signup where sn=?";
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, sn);
			int executeUpdate = prepareStatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Login Credential Deleted Successfully !!";
			}
			else
			{
				result="Something Wrong on DAO : Delete Method";
			}
		}
		catch (Exception e)
		{
			result="Something Wrong on DAO : Delete Method";
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


}
