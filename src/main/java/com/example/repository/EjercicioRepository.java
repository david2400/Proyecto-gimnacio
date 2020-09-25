package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Ejercicio;
@Repository
public interface EjercicioRepository  extends CrudRepository<Ejercicio,Integer>{

}
