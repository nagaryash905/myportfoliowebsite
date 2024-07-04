package com.portfolio.model;

public class ProfilePojo {
	
	private int sn;
	private String name;
	private String designation;
	private String description;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "ProfilePojo [sn=" + sn + ", name=" + name + ", designation=" + designation + ", description="
				+ description + "]";
	}
	
	public ProfilePojo(int sn, String name, String designation, String description) {
		super();
		this.sn = sn;
		this.name = name;
		this.designation = designation;
		this.description = description;
	}
	
	public ProfilePojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
