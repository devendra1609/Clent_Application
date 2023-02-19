package com.akhm.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.akhm.clients.CustomerClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.CustomerService;
import com.akhm.service.dto.CustomerDTO;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerClient customerClient;
	@Autowired
	private RestTemplate restTemplate;
	@Override
	public Integer insertCustomer(CustomerDTO customerDTO) {
		try {
			return customerClient.saveCustomer(customerDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyClientCustomException(e.getMessage());
		}

	}

	@Override
	public CustomerDTO getCustomer(CustomerDTO customerDTO) {
		try {
			
			return restTemplate.postForObject("http://localhost:8080/customer/v1/login", customerDTO, CustomerDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public Boolean isUserExist(String emailId) {
		try {
			return customerClient.isUserExist(emailId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new MyClientCustomException(e.getMessage());
		}
	}

}
