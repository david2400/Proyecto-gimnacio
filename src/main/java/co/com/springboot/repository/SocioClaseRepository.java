package co.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.SocioClase;
@Repository
public interface SocioClaseRepository extends CrudRepository<SocioClase,Integer>{

}
