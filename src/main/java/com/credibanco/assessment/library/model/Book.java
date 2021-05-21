package com.credibanco.assessment.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "book")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = true, nullable = false)
	private Integer id;
	
	@Column(name = "title", length = 100, nullable = false)
	private String title;
	
	@Column(name = "year", length = 50, nullable = true)
	private Integer year;
	
	@Column(name = "gender", length = 100, nullable = false)
	private String gender;
	
	@Column(name = "pages", length = 100, nullable = false)
	private Integer pages;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id", referencedColumnName = "id")
	private Author author;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "editorial_id", referencedColumnName = "id")
	private Editorial editorial;	
	

}
