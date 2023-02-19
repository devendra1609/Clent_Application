package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.clients.CategoryClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.CategoryService;
import com.akhm.service.dto.CategoryDTO;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryClient categoryClient;
	@Override
	public Integer insertCategory(CategoryDTO categoryDTO) {
		log.info("{}-CategoryServiceImpl insertCategory() Started");
		try {
			log.info("{}-CategoryServiceImpl insertCategory() saving Category");
			return categoryClient.saveCategory(categoryDTO);
		} catch (Exception e) {
			log.error("{}-CategoryServiceImpl insertCategory()-exception occured-{}",e.getMessage());
			throw new MyClientCustomException(e.getMessage());
		}

	}

	@Override
	public List<CategoryDTO> getCategories() {
		log.info("{}-CategoryServiceImpl getCategories() Started");
		try {
			log.info("{}-CategoryServiceImpl getCategories() saving Category details in repository");
			return categoryClient.getCategories();
		} catch (Exception e) {
			log.error("{}-CategoryServiceImpl getCategories()-exception occured-{}",e.getMessage());
			throw new MyClientCustomException(e.getMessage());
		}

	}

	@Override
	public CategoryDTO getCategory(Integer categoryId) {
		log.info("{}-CategoryServiceImpl getCategory() Started");
		try {
			log.info("{}-CategoryServiceImpl getCategory() getting Category details in repository");
			return categoryClient.getCategory(categoryId);
		} catch (Exception e) {
			log.error("{}-CategoryServiceImpl getCategory()-exception occured-{}",e.getMessage());
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public void updateCategory(CategoryDTO categoryDTO) {
		log.info("{}-CategoryServiceImpl updateCategory() Started");
		try {
			categoryClient.updateCategory(categoryDTO);
		} catch (Exception e) {
			log.error("{}-CategoryServiceImpl updateCategory()-exception occured-{}",e.getMessage());
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		log.info("{}-CategoryServiceImpl deleteCategory() Started");
		try {
			categoryClient.getCategory(categoryId);
		} catch (Exception e) {
			log.error("{}-CategoryServiceImpl deleteCategory()-exception occured-{}",e.getMessage());
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
