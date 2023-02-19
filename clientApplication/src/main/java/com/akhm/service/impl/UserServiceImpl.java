package com.akhm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.clients.UserClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.UserService;
import com.akhm.service.dto.UserDTO;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserClient userClient;
	@Override
	public Integer insertUser(UserDTO userDTO) {
		try {
			
			return userClient.insertUser(userDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public UserDTO getUser(UserDTO userDTO) {
		try {
			return userClient.getUser(userDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}

	}

	@Override
	public Boolean isUserExist(String emailId) {
		try {
			
			return userClient.isUserExist(emailId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
