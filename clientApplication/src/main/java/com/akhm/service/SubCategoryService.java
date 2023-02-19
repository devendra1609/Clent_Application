package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.SubCategoryDTO;

public interface SubCategoryService {
	public Integer insertSubCategory(SubCategoryDTO subCategoryDTO);
	public List<SubCategoryDTO> getSubCategories();
	public SubCategoryDTO getSubCategory(Integer subCategoryId);
	public void updateSubCategory(SubCategoryDTO subCategoryDTO);
	public void deleteSubCategory(Integer subcategoryId);
}
