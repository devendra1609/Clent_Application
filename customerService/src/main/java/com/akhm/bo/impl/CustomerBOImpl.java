package com.akhm.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.bo.CustomerBO;
import com.akhm.bo.vo.CustomerVO;
import com.akhm.exception.MyCustomCustomerException;
import com.akhm.repository.CustomerRepositoty;
import com.akhm.repository.entity.CustomerEntity;

@Service
public class CustomerBOImpl implements CustomerBO{
	@Autowired
	private CustomerRepositoty customerRepositoty;

	public CustomerVO getCustomer(String emailId, String password) {
		try {
			CustomerEntity customer=customerRepositoty.findByEmailIdAndPassword(emailId, password);
			if(customer!=null) {
				CustomerVO customerVO=new CustomerVO();
				customerVO.setCustomerId(customer.getCustomerId());
				customerVO.setFirstName(customer.getFirstName());
				customerVO.setLastName(customer.getLastName());
				customerVO.setEmailId(customer.getEmailId());
				customerVO.setMobileNumber(customer.getMobileNumber());
				customerVO.setPassword(customer.getPassword());
				
				return customerVO;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new MyCustomCustomerException(e.getMessage());
		}

	}

	public boolean isUserExist(String emailId) {
		boolean isExist=false;
		try {
			CustomerEntity customerEntity=customerRepositoty.findByEmailId(emailId);
			if(customerEntity!=null) {
				isExist=true;
			}
		} catch (Exception e) {
			throw new MyCustomCustomerException(e.getMessage());
		}
		return isExist;
	}

	public Integer insertCustomer(CustomerVO customerVO) {
		try {
			if(customerVO!=null) {
				CustomerEntity customerEntity=new CustomerEntity();
				customerEntity.setFirstName(customerVO.getFirstName());
				customerEntity.setLastName(customerVO.getLastName());
				customerEntity.setEmailId(customerVO.getEmailId());
				customerEntity.setMobileNumber(customerVO.getMobileNumber());
				customerEntity.setPassword(customerVO.getPassword());
				CustomerEntity customer=customerRepositoty.save(customerEntity);
				if(customer!=null) {
					return customer.getCustomerId();
				}else {
					return null;
				}
			}
			else {
				return null;
			}
		} catch (Exception e) {
			throw new MyCustomCustomerException(e.getMessage());
		}

	}
	
	
}
