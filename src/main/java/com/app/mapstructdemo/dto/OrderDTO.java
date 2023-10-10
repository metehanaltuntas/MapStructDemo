package com.app.mapstructdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

	private Long id;
	
	private String orderAmount;
	
	private String description;
	
	private String orderDate;
	
}