package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Socio;
import co.com.springboot.domain.SocioClase;
@Repository
public interface SocioClaseRepository extends CrudRepository<SocioClase,Integer>{
	
	@Query("select S from socio S, socio_clase SC, clase C WHERE S.idsocio=SC.id_socio AND SC.clase_id_clase=C.id_clase AND C.id_clase= :id_clase")
	public Iterable<Socio> ListaSocioClase(@Param("id_clase") int idClase);
	
}
