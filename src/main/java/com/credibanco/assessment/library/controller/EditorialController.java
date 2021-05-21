package com.credibanco.assessment.library.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.IEditorialService;

@RestController
@RequestMapping("editorial")
public class EditorialController {
	
	@Autowired
	private IEditorialService editorialService;
	
	@Autowired
	private ModelMapper modelmapper;

	@PostMapping("/saveEditorial")
	public ResponseEntity<Editorial> registerEditorial(@Valid @RequestBody EditorialDTO editorialDTO) {
		return new ResponseEntity<>(editorialService.saveEditorial(modelmapper.map(editorialDTO, Editorial.class)),
				HttpStatus.CREATED);
	}

}
