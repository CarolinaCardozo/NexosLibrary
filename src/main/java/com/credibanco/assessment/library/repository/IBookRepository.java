package com.credibanco.assessment.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {
	List<Book> findByEditorialId(Integer idEditorial);

}
