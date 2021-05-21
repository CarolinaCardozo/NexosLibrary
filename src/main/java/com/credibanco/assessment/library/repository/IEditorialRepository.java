package com.credibanco.assessment.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.credibanco.assessment.library.model.Editorial;

@Repository
public interface IEditorialRepository extends JpaRepository<Editorial, Integer> {

}
