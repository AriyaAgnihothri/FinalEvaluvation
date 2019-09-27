package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



import com.ust.model.Login;
import com.ust.model.Vendor;
import com.ust.model.VendorContact;

public class MainDao {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	/*---------------------------------LOGIN MODULE-----------------------------*/
	// verify login
		/* (non-Javadoc)
		 * @see com.ust.dao.MainDaoService#selectusername(java.lang.String, java.lang.String)
		 */
	public Login selectUser(String username, String password) {
		String sql = "select user_Id,username,password from login where username = '"+username+"' and password = '"+password+"'";
		return template.queryForObject(sql, new Object[] {},
		new BeanPropertyRowMapper<Login>(Login.class));
		}
/*---------------------------------Vendors MODULE-----------------------------*/

	
	//Get All Vendors
	
		public List<Vendor> getVendor() {
			return template
					.query("select vendor_id,vendor_name,address,location,service,pincode from vendor where isActive=0",
							new RowMapper<Vendor>() {
								public Vendor mapRow(ResultSet rs, int row)
										throws SQLException {
									Vendor v = new Vendor();
									v.setVendor_Id(rs.getInt(1));
									v.setVendor_name(rs.getString(2));
									v.setAddress(rs.getString(3));
									v.setLocation(rs.getString(4));
									v.setService(rs.getString(5));
									v.setPincode(rs.getInt(6));
									return v;
								}
							});
		}
		//get vendor details by id
				public VendorContact getVendorById(int vendor_id) {
					String	sql= "select vc.vendor_id,vc.vendor_name,vc.address,vc.location,vc.service,vc.pincode,cd.contact_name,cd.department,cd.email,cd.phoneno,cd.contact_id from vendor vc join contactdetails cd on vc.vendor_id=cd.vendor_id where vc.isActive=0 and vc.vendor_id='"+ vendor_id + "'";
					return template.queryForObject(sql, new Object[] {}, new BeanPropertyRowMapper<VendorContact>(VendorContact.class));
						
				}
			
		//Get Vendor by Name
		
			public List<Vendor> getVendorByName(String vendor_name) {
				return template
						.query("select vendor_id,vendor_name,address,location,service,pincode from vendor where isActive=0 and vendor_name='"+ vendor_name + "'",
								new RowMapper<Vendor>() {
									public Vendor mapRow(ResultSet rs, int row)
											throws SQLException {
										Vendor v = new Vendor();
										v.setVendor_Id(rs.getInt(1));
										v.setVendor_name(rs.getString(2));
										v.setAddress(rs.getString(3));
										v.setLocation(rs.getString(4));
										v.setService(rs.getString(5));
										v.setPincode(rs.getInt(6));
										return v;
									}
								});
			}
			//Add New Vendors
			
			public int saveVendor(VendorContact vc) {

				String sql1 = "insert into vendor(vendor_name,address,location,service,pincode,isActive) values "
						+ "('"
						+ vc.getVendor_name()
						+ "','"
						+ vc.getAddress()
						+ "','"
						+ vc.getLocation()
						+ "','"
						+ vc.getService()
						+ "','"
						+ vc.getPincode()
						+ "',"
						+ 0
						+ ")";

				 template.update(sql1);
				 
				 Integer maxId = getSequence();
				 String sql2="insert into contactdetails(vendor_id,contact_name,department,email,phoneno) values ("
						 + maxId
							+ ",'"
							+ vc.getContact_name()
							+ "','"
							+ vc.getDepartment()
							+ "','"
							+ vc.getEmail()
							+ "','" + vc.getPhoneno() + "')";
				 return template.update(sql2);

						 
				 
			}
			
			// TO Get Vendor Id
			private Integer getSequence() {
				Integer seq;
				String sql = "select MAX(vendor_id)from vendor";
				seq = template.queryForObject(sql, new Object[] {}, Integer.class);
				return seq;
			}
			// update vendor
			public int updateVendor(int vendor_id, VendorContact vc) {

				String sql = "update vendor set vendor_name='" + vc.getVendor_name()
						+ "' ,address='" + vc.getAddress() + "' ,location='"
						+ vc.getLocation() + "',service='" + vc.getService() + "',pincode='" + vc.getPincode() + "',isActive=" + vc.getIsActive() + " "
						+ "where vendor_id =" + vendor_id;
				template.update(sql);

				// Integer maxId = getSequence();

				String sql1 = "update contactdetails set vendor_id=" + vendor_id + ",contact_name='"
						+ vc.getContact_name() + "',department='"
						+ vc.getDepartment() + "',email='"
						+ vc.getEmail() + "',phoneno='" + vc.getPhoneno() + "'where contact_id = " + vc.getContact_Id();

				return template.update(sql1);
			}
			//Get contactDetails by Id

			public List<VendorContact> getContactDetailsByVId(int vid) {
			return template.query("select contact_id,contact_name,department,vendor_id,email,phoneno from contactdetails where vendor_id="+vid+"", new RowMapper<VendorContact>() {
				public VendorContact mapRow(ResultSet rs, int row)
						throws SQLException {
					VendorContact vc = new VendorContact();
					vc.setContact_Id(rs.getInt(1));
					vc.setContact_name(rs.getString(2));
					vc.setDepartment(rs.getString(3));
					vc.setVendor_Id(rs.getInt(4));
					vc.setEmail(rs.getString(5));
					vc.setPhoneno(rs.getString(6));
					return vc;
				}
			});
			}
			//to disable a vendor
			public int disableVendor(int vId) {

			String sql = "update vendor set isActive='1' where vendor_id=" + vId
			+ "";

			return template.update(sql);
			
		}
}


