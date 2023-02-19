package com.akhm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.SubCategoryDTO;
@FeignClient(value = "subCategoryClient")
public interface SubCategoryClient {
	@RequestMapping(method = RequestMethod.POST,value = "/category/save")
	public Integer saveSubCategory(SubCategoryDTO subCategoryDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/category/get")
	public List<SubCategoryDTO> getSubCategories();
	@RequestMapping(method = RequestMethod.GET,value = "/category/get/{categoryid}")
	public SubCategoryDTO getSubCategory(Integer subCategoryId);
	@RequestMapping(method = RequestMethod.POST,value = "/category/update")
	public void updateSubCategory(SubCategoryDTO subCategoryDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/category/delete")
	public void deleteSubCategory(Integer subCategoryId);
}
