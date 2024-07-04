package com.portfolio.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.ProjectionOrBuilder;
import com.mysql.cj.x.protobuf.MysqlxExpr.Expr;
import com.mysql.cj.x.protobuf.MysqlxExpr.ExprOrBuilder;
import com.portfolio.dao.ConnectionFactory;
import com.portfolio.dao.ProfileDAOImpl;
import com.portfolio.dao.ProjectDAOImpl;
import com.portfolio.model.ProjectPojo;

public class ProjectServiceImpl implements ProjectService {

	private String result;
	@Override
	public String insertProjectService(String project, String description) {
		try 
		{
			ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
			result=projectDAOImpl.insertProjectDAO(project, description);
		}
		catch (Exception e)
		{
			result="Error while Insert Projects The Service DAO Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public ArrayList<ProjectPojo> readProjectService() {
		ArrayList<ProjectPojo> arrayList = null;
		try 
		{
			ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
			arrayList = projectDAOImpl.readProjectDAO();
		} 
		catch (Exception e)
		{
			result="Error while Red The Projects Service DAO Layer";
			e.printStackTrace();
		}
		
		return arrayList;
	}

	@Override
	public String deleteService(String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
			result=projectDAOImpl.deleteProjectDAO(intsn);
		}
		catch (Exception e) 
		{
			result="Error While Delete Project On Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateprojectService(String project, String description, String sn) {
		try 
		{
			int intsn = Integer.parseInt(sn);
			ProjectDAOImpl projectDAOImpl = new ProjectDAOImpl();
			result=projectDAOImpl.updateProjectDAO(project, description, intsn);
		}
		catch (Exception e) 
		{
			result="Error While Update Project On Service Layer";
			e.printStackTrace();
		}
		return result;
	}

	
}
