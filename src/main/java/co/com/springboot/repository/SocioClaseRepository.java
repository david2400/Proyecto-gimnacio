package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Socio;
import co.com.springboot.domain.SocioClase;
@Repository
public interface SocioClaseRepository extends CrudRepository<SocioClase,Integer>{
	
	@Query("select s from Socio s,SocioClase sc WHERE s=sc.socio AND sc.clase.idClase= :idClase")
	public Iterable<Socio> ListaSocioClase(@Param("idClase") Integer idClase);

}
