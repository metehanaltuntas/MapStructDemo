package com.app.mapstructdemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "salary")
	private float salary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="dept_id",foreignKey = @ForeignKey(name = "emp_dept_fk"))
	private Department department;

}