package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Rutina;
@Repository
public interface RutinaRepository extends CrudRepository<Rutina,Integer> {

}
