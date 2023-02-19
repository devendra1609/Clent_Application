package com.akhm.service;

import com.akhm.service.dto.AdminDTO;

public interface AdminService {
	public AdminDTO getAdmin(String emailId,String password);
	
}
