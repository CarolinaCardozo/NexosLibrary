package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.repository.IAuthorRepository;
import com.credibanco.assessment.library.service.IAuthorService;

@Service
public class AuthorServiceImp implements IAuthorService {
	
	@Autowired
	private IAuthorRepository authorRepository;

	@Override
	public Author saveAuthor(Author author) {
		return authorRepository.save(author);
	}

}
