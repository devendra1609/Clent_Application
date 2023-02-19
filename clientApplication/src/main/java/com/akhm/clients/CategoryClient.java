package com.akhm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.CategoryDTO;

@FeignClient(value = "categoryClient")
public interface CategoryClient {
	@RequestMapping(method = RequestMethod.POST,value = "/category/save")
	public Integer saveCategory(CategoryDTO categoryDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/category/get")
	public List<CategoryDTO> getCategories();
	@RequestMapping(method = RequestMethod.GET,value = "category/get/{categoryid}")
	public CategoryDTO getCategory(Integer categoryId);
	@RequestMapping(method = RequestMethod.POST, value = "/category/update")
	public void updateCategory(CategoryDTO categoryDTO);
	@RequestMapping(method = RequestMethod.GET, value = "/category/delete")
	public void deleteCategory(Integer categoryId);
}
