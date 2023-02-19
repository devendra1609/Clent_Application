package com.akhm.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.UserDTO;

@FeignClient(value = "userClient")
public interface UserClient {
	@RequestMapping(method=RequestMethod.POST,value="/registration")
	public Integer insertUser(UserDTO userDTO);
	@RequestMapping(method=RequestMethod.GET,value="/isuserexist")
	public Boolean isUserExist(String emailId);
	@RequestMapping(method=RequestMethod.POST,value="/login")
	public UserDTO getUser(UserDTO userDTO);
}
