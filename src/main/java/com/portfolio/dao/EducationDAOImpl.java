package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.model.EducationPojo;

public class EducationDAOImpl implements EducationDAO {

	private String result;
	private Connection connection;
	@Override
	public String insertEducationDAO(String year, String school, String section, String description) {
		try 
		{	
			Connection connection = ConnectionFactory.getConnection();
			String sql="insert into education(year,school,section,description) values(?,?,?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, year);
			preparestatement.setString(2, school);
			preparestatement.setString(3, section);
			preparestatement.setString(4, description);
			
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Education Added Successfully !!";
			}
			else
			{
				result="Error on DAO Layer while Insert the Education";
			}
		} 
		catch (Exception e)
		{
			result="Error on DAO Layer while Insert the Education";
			e.printStackTrace();
		}
		return result;
	}
	
	
	@Override
	public ArrayList<EducationPojo> readEducationDAO() {
		
			ArrayList<EducationPojo> arrayList = new ArrayList<EducationPojo>();
			try 
			{
				 connection = ConnectionFactory.getConnection();
				String sql="select * from education";
				PreparedStatement preparestatement = connection.prepareStatement(sql);
				ResultSet rs = preparestatement.executeQuery();
				
				if(!rs.next())
				{
					arrayList.add(new EducationPojo(0,"ne","ne","ne","ne","ne"));
				}
				else 
				{
					do
					{
						arrayList.add(new EducationPojo(rs.getInt("sn"),rs.getString("year"),rs.getString("school"),
								rs.getString("section"),rs.getString("description")));
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
	public String deleteEducation(int sn) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from education where sn=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, sn);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Education Deleted Successfully !!";
			}
			else
			{
				result="Something Wrong on Education DAO : Delete Method";
			}
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			result="Something Wrong on Education DAO : Delete Method";
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


	@Override
	public String UpdateEducation(String year, String school, String section, String description, int sn) {
		try (Connection connection = ConnectionFactory.getConnection())
	    {
	        String sql = "UPDATE education SET year=?, school=?, section=? ,description=? WHERE sn=?";
	        try (PreparedStatement preparestatement = connection.prepareStatement(sql)) {
	            preparestatement.setString(1, year);
	            preparestatement.setString(2, school);
	            preparestatement.setString(3, section);
	            preparestatement.setString(4, description);
	            preparestatement.setInt(5, sn);
	            int executeUpdate = preparestatement.executeUpdate();
	            if (executeUpdate == 1) 
	            {
	                result = "Education Updated Successfully !!";
	            } 
	            else 
	            {
	                result = "Error while Updating the Education on DAO Layer";
	            }
	        }
	    } 
	    catch (Exception e)
	    {
	        result = "Error while Updating the Education on DAO Layer";
	        e.printStackTrace();
	    }
	    return result;
	}

}
