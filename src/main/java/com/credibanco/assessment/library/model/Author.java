package com.credibanco.assessment.library.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "author")
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = true, nullable = false)
	private Integer id;
	
	@Column(name = "fullname", length = 100, nullable = false)
	private String fullname;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dateOfBirth", nullable = true)
	private Date dateOfBirth;
		
	@Column(name = "city", length = 100, nullable = true)
	private String city;
		
	@Column(name = "email", length = 100, nullable = true)
	private String email;
	
}
