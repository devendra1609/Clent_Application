package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.entity.CustomerEntity;

@Repository
public interface CustomerRepositoty extends JpaRepository<CustomerEntity, Integer>{
	public CustomerEntity findByEmailIdAndPassword(String emailId,String password);
	public CustomerEntity findByEmailId(String emailId);
}
