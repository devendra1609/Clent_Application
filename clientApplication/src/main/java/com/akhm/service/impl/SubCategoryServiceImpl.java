package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.clients.SubCategoryClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.SubCategoryService;
import com.akhm.service.dto.SubCategoryDTO;
@Service
public class SubCategoryServiceImpl implements SubCategoryService {
	@Autowired
	private SubCategoryClient subCategoryClient;
	@Override
	public Integer insertSubCategory(SubCategoryDTO subCategoryDTO) {
		try {
			return subCategoryClient.saveSubCategory(subCategoryDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public List<SubCategoryDTO> getSubCategories() {
		try {
			return subCategoryClient.getSubCategories();
			
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public SubCategoryDTO getSubCategory(Integer subCategoryId) {
		try {
			return subCategoryClient.getSubCategory(subCategoryId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public void updateSubCategory(SubCategoryDTO subCategoryDTO) {
		try {
			subCategoryClient.updateSubCategory(subCategoryDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteSubCategory(Integer subcategoryId) {
		try {
			subCategoryClient.deleteSubCategory(subcategoryId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
