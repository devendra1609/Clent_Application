package com.akhm.service;

import java.util.List;

import com.akhm.service.dto.ProductDTO;

public interface ProductService {
	public Integer insertProduct(ProductDTO productDTO);
	public List<ProductDTO> getProducts();
	public ProductDTO getProduct(Integer productId);
	public void updateProduct(ProductDTO productDTO);  
	public void deleteProduct(Integer productId);
}
