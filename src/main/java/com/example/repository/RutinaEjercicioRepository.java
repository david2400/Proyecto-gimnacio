package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.RutinaEjercicio;
@Repository
public interface RutinaEjercicioRepository extends CrudRepository<RutinaEjercicio,Integer>{

}
