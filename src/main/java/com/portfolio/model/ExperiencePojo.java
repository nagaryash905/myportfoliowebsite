package com.portfolio.model;

public class ExperiencePojo {
	
	private int sn;
	private String year;
	private String jobtitle;
	private String company;
	private String description;
	
	public ExperiencePojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExperiencePojo(int sn, String year, String jobtitle, String company, String description) {
		super();
		this.sn = sn;
		this.year = year;
		this.jobtitle = jobtitle;
		this.company = company;
		this.description = description;
	}

	@Override
	public String toString() {
		return "ExperiencePojo [sn=" + sn + ", year=" + year + ", jobtitle=" + jobtitle + ", company=" + company
				+ ", description=" + description + "]";
	}

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

	public String getJobtitle() {
		return jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
