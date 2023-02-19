package com.akhm.service.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ProductPriceDTO {
	private Integer productPriceId;
	private Integer productId;
	private Double amount;
	private String status;
	private Date createdon;
	
}
