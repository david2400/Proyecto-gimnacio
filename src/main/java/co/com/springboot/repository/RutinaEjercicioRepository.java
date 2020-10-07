package co.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import co.com.springboot.domain.RutinaEjercicio;
@Repository
public interface RutinaEjercicioRepository extends CrudRepository<RutinaEjercicio,Integer>{
	
	
}
