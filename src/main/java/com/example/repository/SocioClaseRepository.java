package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.SocioClase;
@Repository
public interface SocioClaseRepository extends CrudRepository<SocioClase,Integer>{

}
