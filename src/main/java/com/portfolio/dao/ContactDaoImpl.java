package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import com.portfolio.model.ContactPojo;

public class ContactDaoImpl implements ContactDao {

	private String result;
	private Connection connection;
	@Override
	public String insertContactDAO(String name, String email, String message,String datetime) {
		try 
		{
			connection = ConnectionFactory.getConnection();
			String sql="insert into message(name,email,message,datetime) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, message);
			preparedStatement.setString(4, datetime);
			int executeUpdate = preparedStatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Message Sent Successfully !! ";
			}
			else
			{
				result="Something Wrong !! ";
			}
		} 
		catch (Exception e)
		{
			result="DAO Error while send Message";
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public ArrayList<ContactPojo> readContactDAO() {
		
			ArrayList<ContactPojo> arrayList = new ArrayList<ContactPojo>();
			try 
			{
				connection = ConnectionFactory.getConnection();
				String sql="select * from message";
				PreparedStatement preparestatement = connection.prepareStatement(sql);
				ResultSet rs = preparestatement.executeQuery();
				
				if(!rs.next())
				{
					arrayList.add(new ContactPojo(0,"ne","ne","ne","ne"));
				}
				else 
				{
					do 
					{
						arrayList.add(new ContactPojo(rs.getInt("sn"),rs.getString("name"),rs.getString("email"),
								rs.getString("message"),rs.getString("datetime")));
					}
					while(rs.next());
				}
			} 
			catch (Exception e) 
			{
				result="Error on DAO Laywer while Read Contact";
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
	public String deleteContact(String sn) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from message where sn=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, sn);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Message Deleted Successfully !!";
			}
			else
			{
				result="Mesage Not Deleted";
			}
		} 
		catch (Exception e) 
		{
			result="Error While Delete The Contacts";
			e.printStackTrace();
		}
		
		return result;
	}

}
