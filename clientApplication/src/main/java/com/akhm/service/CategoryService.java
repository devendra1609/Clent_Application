package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.CategoryDTO;


public interface CategoryService {
	public Integer insertCategory(CategoryDTO categoryDTO);
	public List<CategoryDTO> getCategories();
	public CategoryDTO getCategory(Integer categoryId);
	public void updateCategory(CategoryDTO categoryDTO);
	public void deleteCategory(Integer categoryId);
}
