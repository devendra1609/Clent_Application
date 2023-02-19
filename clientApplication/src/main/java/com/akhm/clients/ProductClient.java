package com.akhm.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.akhm.service.dto.ProductDTO;

@FeignClient(value = "productClient")
public interface ProductClient {
	@RequestMapping(method = RequestMethod.POST,value = "/product/save")
	public Integer saveProduct(ProductDTO productDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/product/get")
	public List<ProductDTO> getProducts();
	@RequestMapping(method = RequestMethod.GET,value = "/product/get/{productid}")
	public ProductDTO getProduct(Integer productId);
	@RequestMapping(method = RequestMethod.POST,value = "/product/update")
	public void updateProduct(ProductDTO productDTO);
	@RequestMapping(method = RequestMethod.GET,value = "/product/delete")
	public void deleteProduct(Integer productId);
}
