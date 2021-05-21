package com.credibanco.assessment.library.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Editorial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	@NotEmpty(message = "title no puede ser vacío")
	@NotNull(message = "title no puede ser nulo")
	private String title;
	
	private Integer year;
	
	@NotEmpty(message = "gender no puede ser vacío")
	@NotNull(message = "gender no puede ser nulo")
	private String gender;
	
	@NotNull(message = "pages no puede ser nulo")
	private Integer pages;
	
	@NotNull(message = "author no puede ser nulo")
	private Author author;
	
	private Editorial editorial;	

}
