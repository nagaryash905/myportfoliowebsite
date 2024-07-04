package com.portfolio.model;

public class EducationPojo {
	
	private int sn;
	private String year;
	private String school;
	private String section;
	private String description;
	
	public int getSn() {
		return sn;
	}
	public void setSn(int sn) {
		this.sn = sn;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public EducationPojo(int sn,String year, String school, String section, String description) {
		super();
		this.sn=sn;
		this.year = year;
		this.school = school;
		this.section = section;
		this.description = description;
	}
	
	public EducationPojo(int i, String string, String string2, String string3, String string4, String string5) {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "EducationPojo [sn=" + sn + ", year=" + year + ", school=" + school + ", section=" + section
				+ ", description=" + description + "]";
	}
	
	

}
