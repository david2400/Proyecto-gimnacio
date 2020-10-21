package co.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Ejercicio;
import co.com.springboot.domain.Tiposala;
@Repository
public interface TipoSalaRepository extends CrudRepository<Tiposala,Integer>{

	
}
