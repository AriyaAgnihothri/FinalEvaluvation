package com.ust.model;

public class ContactDetails {
	private int contact_Id;
	private String contact_name;
	private int vendore_Id;
	private String department;
	private String email;
	private String phoneno;
	
	//Getters and Setters
	public int getContact_Id() {
		return contact_Id;
	}
	public void setContact_Id(int contact_Id) {
		this.contact_Id = contact_Id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public int getVendore_Id() {
		return vendore_Id;
	}
	public void setVendore_Id(int vendore_Id) {
		this.vendore_Id = vendore_Id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	//Constructor using Fields
	public ContactDetails(int contact_Id, String contact_name, int vendore_Id,
			String department, String email, String phoneno) {
		super();
		this.contact_Id = contact_Id;
		this.contact_name = contact_name;
		this.vendore_Id = vendore_Id;
		this.department = department;
		this.email = email;
		this.phoneno = phoneno;
	}
	//Constructor using Superclass
	public ContactDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	//toString
	@Override
	public String toString() {
		return "ContactDetails [contact_Id=" + contact_Id + ", contact_name="
				+ contact_name + ", vendore_Id=" + vendore_Id + ", department="
				+ department + ", email=" + email + ", phoneno=" + phoneno
				+ "]";
	}
	
	

}
