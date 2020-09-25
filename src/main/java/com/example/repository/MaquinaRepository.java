package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Maquina;
@Repository
public interface MaquinaRepository extends CrudRepository<Maquina,Integer>{

}
