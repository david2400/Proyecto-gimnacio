package co.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Sala;
@Repository
public interface SalaRepository extends CrudRepository<Sala,Integer>{

}
