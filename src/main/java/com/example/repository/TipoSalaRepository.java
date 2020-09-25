package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Tiposala;
@Repository
public interface TipoSalaRepository extends CrudRepository<Tiposala,Integer>{

}
