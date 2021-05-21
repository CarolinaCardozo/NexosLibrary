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

import com.credibanco.assessment.library.dto.BookDTO;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.service.IBookService;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private IBookService bookService;

	@Autowired
	private ModelMapper modelmapper;

	@PostMapping("/saveBook")
	public ResponseEntity<Book> registerAuthor(@Valid @RequestBody BookDTO bookDTO) {
		return new ResponseEntity<>(bookService.saveBook(modelmapper.map(bookDTO, Book.class)), HttpStatus.CREATED);
	}

}
