package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.portfolio.model.ProjectPojo;

public class ProjectDAOImpl implements ProjectDAO {

	private String result;
	private Connection connection;
	@Override
	public String insertProjectDAO(String project, String description) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="insert into project(project,description) values(?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, project);
			preparestatement.setString(2, description);
			int executeUpdate = preparestatement.executeUpdate();
			
			if(executeUpdate==1)
			{
				result="Project Added Successfully !!";
			}
			else
			{
				result="Error while Insert The Project DAO Layer";
			}
		}
		catch (Exception e)
		{
			result="Error while Insert The Project DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ProjectPojo> readProjectDAO() {
		
		ArrayList<ProjectPojo> arrayList = new ArrayList<ProjectPojo>();
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from project";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			ResultSet rs = preparestatement.executeQuery();
			
			if(!rs.next())
			{
				arrayList.add(new ProjectPojo(0,"ne","ne"));
			}
			else
			{
				do
				{
					arrayList.add(new ProjectPojo(rs.getInt("sn"),rs.getString("project"),
							rs.getString("description")));
				}
				while(rs.next());
			}
		}
		catch (Exception e)
		{
			result="Error while Read The Project DAO Layer";
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
	public String deleteProjectDAO(int sn) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from project where sn=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, sn);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Project Deleted Successfully !!";
			}
			else
			{
				result="Error while Delete The Project DAO Layer";
			}
		}
		catch (Exception e)
		{
			result="Error while Delete The Project DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateProjectDAO(String project, String description, int sn) {
		try (Connection connection = ConnectionFactory.getConnection())
	    {
	        String sql = "UPDATE project SET project=?,description=? WHERE sn=?";
	        try (PreparedStatement preparestatement = connection.prepareStatement(sql)) {
	            preparestatement.setString(1, project);
	            preparestatement.setString(2, description);
	            preparestatement.setInt(3, sn);
	            int executeUpdate = preparestatement.executeUpdate();
	            if (executeUpdate == 1) 
	            {
	                result = "Project Updated Successfully !!";
	            } 
	            else 
	            {
	                result = "Error while Updating the Project on DAO Layer";
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
