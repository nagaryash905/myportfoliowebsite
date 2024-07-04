package com.portfolio.model;

public class CredentilasPojo {

	private int sn;
	private String name;
	private String email;
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public CredentilasPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CredentilasPojo [sn=" + sn + ", name=" + name + ", email=" + email + ", password=" + password + "]";
	}

	public CredentilasPojo(int sn, String name, String email, String password) {
		super();
		this.sn = sn;
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
