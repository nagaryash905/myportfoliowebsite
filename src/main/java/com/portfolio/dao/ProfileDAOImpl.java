package com.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.portfolio.model.ProfilePojo;

public class ProfileDAOImpl implements ProfileDAO {

	private String result;
	private Connection connection;
	@Override
	public String inserProfileDAO(String name, String designation, String description) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="insert into profile(name,designation,description) values(?,?,?)";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setString(1, name);
			preparestatement.setString(2, designation);
			preparestatement.setString(3, description);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Profile Data Inserted Successfully";
			}
			else
			{
				result="Error While Insert Profile On DAO Layer";
			}
		} 
		catch (Exception e) 
		{
			result="Error While Insert Profile On DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ProfilePojo> readProfileDAO() {
		
		ArrayList<ProfilePojo> arrayList = new ArrayList<ProfilePojo>();
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="select * from profile";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			ResultSet rs = preparestatement.executeQuery();
			if(!rs.next())
			{
				arrayList.add(new ProfilePojo(0,"ne","ne","ne"));
			}
			do
			{
				arrayList.add(new ProfilePojo(rs.getInt("sn"),rs.getString("name"),rs.getString("designation"),
						rs.getString("description")));
			}
			while(rs.next());
		} 
		catch (Exception e) 
		{
			result="Error while read the Profile on DAO Layer";
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public String deleteProfileDAO(int sn) {
		try 
		{
			connection=ConnectionFactory.getConnection();
			String sql="delete from profile where sn=?";
			PreparedStatement preparestatement = connection.prepareStatement(sql);
			preparestatement.setInt(1, sn);
			int executeUpdate = preparestatement.executeUpdate();
			if(executeUpdate==1)
			{
				result="Profile Deleted Successfully !!";
			}
			else
			{
				result="Error while Delete the Profile on DAO Layer";
			}
		}
		catch (Exception e)
		{
			result="Error while Delete the Profile on DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateProfileDAO(String name, String designation, String description, int sn) {
	    try (Connection connection = ConnectionFactory.getConnection())
	    {
	        String sql = "UPDATE profile SET name=?, designation=?, description=? WHERE sn=?";
	        try (PreparedStatement preparestatement = connection.prepareStatement(sql)) {
	            preparestatement.setString(1, name);
	            preparestatement.setString(2, designation);
	            preparestatement.setString(3, description);
	            preparestatement.setInt(4, sn);
	            int executeUpdate = preparestatement.executeUpdate();
	            if (executeUpdate == 1) 
	            {
	                result = "Profile Updated Successfully !!";
	            } else 
	            {
	                result = "Error while Updating the Profile on DAO Layer";
	            }
	        }
	    } 
	    catch (Exception e)
	    {
	        result = "Error while Updating the Profile on DAO Layer";
	        e.printStackTrace();
	    }
	    return result;
	}


}
