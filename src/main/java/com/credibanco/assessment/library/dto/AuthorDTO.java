package com.credibanco.assessment.library.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
	
	@NotEmpty(message = "fullname no puede ser vacío")
	@NotNull(message = "fullname no puede ser nulo")
	private String fullname;
	
	private Date dateOfBirth;
		
	private String city;

	@Email
	private String email;
}
