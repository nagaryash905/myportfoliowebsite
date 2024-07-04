package com.portfolio.model;

public class ProjectPojo {

	private int sn;
	private String project;
	private String description;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProjectPojo(int sn, String project, String description) {
		super();
		this.sn = sn;
		this.project = project;
		this.description = description;
	}
	
	public ProjectPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ProjectPojo [sn=" + sn + ", project=" + project + ", description=" + description + "]";
	}
	
	
	
	
}
