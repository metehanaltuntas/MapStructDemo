package com.app.mapstructdemo.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Entity(name="order_details")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="description")
	private String description;
	
	@Column(name="order_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name="status")
	private boolean status;

}