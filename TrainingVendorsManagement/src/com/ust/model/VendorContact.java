package com.ust.model;

public class VendorContact {
	private int vendor_Id;
	private String vendor_name;
	private String address;
	private String location;
	private String service;
	private int pincode;
	private int isActive;
	private int contact_Id;
	private String contact_name;
	private String department;
	private String email;
	private String phoneno;
	
	public int getVendor_Id() {
		return vendor_Id;
	}
	public void setVendor_Id(int vendor_Id) {
		this.vendor_Id = vendor_Id;
	}
	public String getVendor_name() {
		return vendor_name;
	}
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
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
	public VendorContact(int vendor_Id, String vendor_name, String address,
			String location, String service, int pincode, int isActive,
			int contact_Id, String contact_name, String department,
			String email, String phoneno) {
		super();
		this.vendor_Id = vendor_Id;
		this.vendor_name = vendor_name;
		this.address = address;
		this.location = location;
		this.service = service;
		this.pincode = pincode;
		this.isActive = isActive;
		this.contact_Id = contact_Id;
		this.contact_name = contact_name;
		this.department = department;
		this.email = email;
		this.phoneno = phoneno;
	}
	public VendorContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "VendorContact [vendor_Id=" + vendor_Id + ", vendor_name="
				+ vendor_name + ", address=" + address + ", location="
				+ location + ", service=" + service + ", pincode=" + pincode
				+ ", isActive=" + isActive + ", contact_Id=" + contact_Id
				+ ", contact_name=" + contact_name + ", department="
				+ department + ", email=" + email + ", phoneno=" + phoneno
				+ "]";
	}
	

}
