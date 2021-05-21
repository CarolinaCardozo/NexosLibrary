package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "editorial")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = true, nullable = false)
	private Integer id;
	
	@Column(name = "name", length = 100, nullable = false)
	private String name;
			
	@Column(name = "address", length = 100, nullable = false)
	private String address;
		
	@Column(name = "phone", length = 30, nullable = false)
	private String phone;
	
	@Column(name = "email", length = 100, nullable = true)
	private String email;
	
	@Column(name = "max_registers", length = 10, nullable = false)
	private int maxRegisters;

}
