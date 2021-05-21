package com.credibanco.assessment.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.IEditorialRepository;
import com.credibanco.assessment.library.service.IEditorialService;

@Service
public class EditorialServiceImp implements IEditorialService {
	
	@Autowired
	private IEditorialRepository editorialRepository;

	@Override
	public Editorial saveEditorial(Editorial author) {
		if(author.getMaxRegisters() == 0) {
			author.setMaxRegisters(-1);
		}
	
		return editorialRepository.save(author);
	}

}
