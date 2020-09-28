package co.com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.ClaseSala;
@Repository
public interface ClaseSalaRepository  extends CrudRepository<ClaseSala,Integer>{

}
