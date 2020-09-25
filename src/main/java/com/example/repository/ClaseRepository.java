package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Clase;
@Repository
public interface ClaseRepository  extends CrudRepository<Clase,Integer>{

}
