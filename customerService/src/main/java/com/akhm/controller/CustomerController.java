package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akhm.bo.CustomerBO;
import com.akhm.bo.vo.CustomerVO;

@Controller
@RequestMapping("/customer/v1")
public class CustomerController {
	@Autowired
	private CustomerBO customerBO;
	@GetMapping("/isuserexist")
	public ResponseEntity<Boolean> isUserExist(@RequestParam String emailId){
		try {
			Boolean isExist=customerBO.isUserExist(emailId);
			return new ResponseEntity<Boolean>(isExist,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/registration")
	public ResponseEntity<Integer> registration(@RequestBody CustomerVO customerVO){
		try {
			Integer customerId=customerBO.insertCustomer(customerVO);
			return new ResponseEntity<Integer>(customerId,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		

	}
	@PostMapping("/login")
	public ResponseEntity<CustomerVO> logIn(@RequestBody CustomerVO customerVO){
		try {
			CustomerVO customer=customerBO.getCustomer(customerVO.getEmailId(), customerVO.getPassword());
			
			return new ResponseEntity<CustomerVO>(customer,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<CustomerVO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}
