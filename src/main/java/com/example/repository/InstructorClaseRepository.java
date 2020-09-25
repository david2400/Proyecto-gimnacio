package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.InstructorClase;

@Repository
public interface InstructorClaseRepository  extends CrudRepository<InstructorClase,Integer>{

}
