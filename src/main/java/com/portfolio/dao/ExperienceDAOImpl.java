package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.model.ExperiencePojo;

public class ExperienceDAOImpl implements ExperienceDAO {

	private String result;
	private Connection connection;
	@Override
	public String insertExperienceDAO(String year, String jobtitle, String company, String description) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="insert into experience(year,jobtitle,company,description) values(?,?,?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, year);
			preparestatement.setString(2, jobtitle);
			preparestatement.setString(3, company);
			preparestatement.setString(4, description);
			
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Experience Added Successfully !!";
			}
			else
			{
				result="Error while insert the Experience DAO Layer";
			}
		}
		catch (Exception e)
		{
			result="Error while insert the Experience DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ExperiencePojo> readExperienceDAO() {
		
		ArrayList<ExperiencePojo> arrayList = new ArrayList<ExperiencePojo>();
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from experience";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			ResultSet rs = preparestatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ExperiencePojo(0,"ne","ne","ne","ne"));
			}
			else
			{
				do
				{
					arrayList.add(new ExperiencePojo(rs.getInt("sn"),rs.getString("year"),rs.getString("jobtitle"),
							rs.getString("company"),rs.getString("description")));
				}
				while(rs.next());
			}
		}
		catch (Exception e)
		{
			arrayList.clear();
			e.printStackTrace();
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
	public String deleteExperience(int sn) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from experience where sn=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, sn);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Experience Delete Successfully !!";
			}
			else
			{
				result="Error while Delete the Experience DAO Layer";
			}
		}
		catch (Exception e)
		{
			result="Error while Delete the Experience DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateExperience(String year, String jobtitle, String company, String description, int sn) {
		try (Connection connection = ConnectionFactory.getConnection())
	    {
	        String sql = "UPDATE experience SET year=?, jobtitle=?, company=? ,description=? WHERE sn=?";
	        try (PreparedStatement preparestatement = connection.prepareStatement(sql)) {
	            preparestatement.setString(1, year);
	            preparestatement.setString(2, jobtitle);
	            preparestatement.setString(3, company);
	            preparestatement.setString(4, description);
	            preparestatement.setInt(5, sn);
	            int executeUpdate = preparestatement.executeUpdate();
	            if (executeUpdate == 1) 
	            {
	                result = "Project Updated Successfully !!";
	            } 
	            else 
	            {
	                result = "Error while Updating the Experience on DAO Layer";
	            }
	        }
	    } 
	    catch (Exception e)
	    {
	        result = "Error while Updating the Project on DAO Layer";
	        e.printStackTrace();
	    }
	    return result;
	}

}
