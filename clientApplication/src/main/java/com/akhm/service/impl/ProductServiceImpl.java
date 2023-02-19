package com.akhm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.clients.ProductClient;
import com.akhm.exception.MyClientCustomException;
import com.akhm.service.ProductService;
import com.akhm.service.dto.ProductDTO;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductClient productClient;
	@Override
	public Integer insertProduct(ProductDTO productDTO) {
		try {
			return productClient.saveProduct(productDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public List<ProductDTO> getProducts() {
		try {
			return productClient.getProducts();
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}

	}

	@Override
	public ProductDTO getProduct(Integer productId) {
		try {
			return productClient.getProduct(productId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
	}

	@Override
	public void updateProduct(ProductDTO productDTO) {
		try {
			productClient.updateProduct(productDTO);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

	@Override
	public void deleteProduct(Integer productId) {
		try {
			productClient.deleteProduct(productId);
		} catch (Exception e) {
			throw new MyClientCustomException(e.getMessage());
		}
		
	}

}
