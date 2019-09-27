package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.dao.MainDao;
import com.ust.model.Login;
import com.ust.model.VendorContact;
@RestController
public class MainController {
	
	@Autowired
	MainDao dao;
	
	/*---------------------------------LOGIN MODULE-----------------------------*/

	// verify login
	@RequestMapping(value = "/api/login/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Login selectUser(@PathVariable("username") String userName,
	@PathVariable("password") String password) {
	return dao.selectUser(userName, password);
	}
	
	
	//view vendors
	
			@RequestMapping(value = "/api/vendor/{vendor_name}", method = RequestMethod.GET)
			@ResponseBody
			public List getVendor(Model m, @PathVariable("vendor_name") String vendor_name) {
				List list;
				if (vendor_name.equals("null")) {
					list = dao.getVendor();
				} else {
					list = dao.getVendorByName(vendor_name);
					
				}
				return list;

			}
			// Add Vendor
			@ResponseBody
			@RequestMapping(value = "/api/insertvendor", method = RequestMethod.POST)
			public void insertDoctor(@RequestBody VendorContact vc) throws ParseException {
				dao.saveVendor(vc);
			}
			// update Vendor
			@ResponseBody
			@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
			public void updateDoctor(@RequestBody VendorContact vc) throws ParseException {
				int vendor_id = vc.getVendor_Id();
				dao.updateVendor(vendor_id, vc);
			}
			// to disable a vendor

			@RequestMapping(value = "/api/disablevendor/{vId}", method = RequestMethod.PUT)
			@ResponseBody
			public void disableStaff(@PathVariable("vId") int vId) {
			dao.disableVendor(vId);
			}
			
			// view contactdetails by vendor id

			@RequestMapping(value = "/api/contactDetails/{vId}", method = RequestMethod.GET)
			@ResponseBody
			public List getContactDetails(Model m,@PathVariable("vId") int vId) {
				List list;
			list=dao.getContactDetailsByVId(vId);
			return list;

			}
			// view vendor list by id
			@RequestMapping(value = "/api/vendors/{vendor_id}", method = RequestMethod.GET)
			@ResponseBody
			public VendorContact getvendors(Model m, @PathVariable("vendor_id") int vendor_id) {
				
				
				return dao.getVendorById(vendor_id);
			}

}

