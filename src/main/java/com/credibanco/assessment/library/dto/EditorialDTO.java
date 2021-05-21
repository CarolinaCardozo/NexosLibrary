package com.credibanco.assessment.library.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditorialDTO {
		
	@NotEmpty(message = "name no puede ser vacío")
	@NotNull(message = "name no puede ser nulo")
	private String name;
			
	@NotEmpty(message = "address no puede ser vacío")
	@NotNull(message = "address no puede ser nulo")
	private String address;		
	
	@NotEmpty(message = "phone no puede ser vacío")
	@NotNull(message = "phone no puede ser nulo")
	private String phone;
	
	@Email
	private String email;
	
	private int maxRegisters;

}
