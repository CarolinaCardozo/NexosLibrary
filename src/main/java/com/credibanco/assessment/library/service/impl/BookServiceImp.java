package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.error.ErrorEnum;
import com.credibanco.assessment.library.exceptions.CustomException;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.IAuthorRepository;
import com.credibanco.assessment.library.repository.IBookRepository;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.service.IBookService;

@Service
public class BookServiceImp implements IBookService {

	@Autowired
	private IBookRepository bookRepository;

	@Autowired
	private IAuthorRepository authorRepository;

	@Autowired
	private IEditorialRepository editorialRepository;

	@Override
	public Book saveBook(Book book) {

		// Validar si el autor existe
		Optional<Author> author = authorRepository.findById(book.getAuthor().getId());
		if (!author.isPresent()) {
			throw new CustomException(HttpStatus.BAD_REQUEST, ErrorEnum.AUTHOR_NOT_FOUND);
		}

		if (book.getEditorial() != null) {
			// validar si la editorial existe
			Optional<Editorial> editorial = editorialRepository.findById(book.getEditorial().getId());
			if (!editorial.isPresent()) {
				throw new CustomException(HttpStatus.BAD_REQUEST, ErrorEnum.EDITORIAL_NOT_FOUND);
			}
			// validar máximo permitido
			List<Book> listbookByEditorial = bookRepository.findByEditorialId(book.getEditorial().getId());
			System.out.println("cantidad de registros de la editorial: "+ listbookByEditorial.size());
			
			if(listbookByEditorial.size() >= editorial.get().getMaxRegisters()) {
				throw new CustomException(HttpStatus.BAD_REQUEST, ErrorEnum.MAXIMUM_ALLOWED);
			}
		}
		
		return bookRepository.save(book);
	}

}
