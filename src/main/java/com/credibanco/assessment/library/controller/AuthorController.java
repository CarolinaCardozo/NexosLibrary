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

import com.credibanco.assessment.library.dto.AuthorDTO;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.service.IAuthorService;

@RestController
@RequestMapping("author")
public class AuthorController {

	@Autowired
	private IAuthorService authorService;

	@Autowired
	private ModelMapper modelmapper;

	@PostMapping("/saveAuthor")
	public ResponseEntity<Author> registerAuthor(@Valid @RequestBody AuthorDTO authorDTO ) {
		return new ResponseEntity<>(authorService.saveAuthor(modelmapper.map(authorDTO, Author.class)),
				HttpStatus.CREATED);
	}

}
