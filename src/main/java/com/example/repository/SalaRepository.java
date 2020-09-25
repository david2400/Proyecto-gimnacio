package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Sala;
@Repository
public interface SalaRepository extends CrudRepository<Sala,Integer>{

}
