package co.com.springboot.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import co.com.springboot.domain.Clase;
@Repository
public interface ClaseRepository  extends CrudRepository<Clase,Integer>{
	
	@Query("select C from clase C JOIN socio_clase SC ON SC.clase_id_clase=C.id_clase JOIN socio S ON S.idsocio=SC.id_socio where S.idsocio=?1")
	public ArrayList<Clase> SocioClase(String idSocio);
	
	@Query("select C from socio S  JOIN socio_clase SC ON S.idsocio=SC.id_socio JOIN clase C ON SC.clase_id_clase=C.id_clase where C.id_clase=?1")
	public ArrayList<Clase> ListaSocioClase(String idClase);
	
	
	
	
	
	
	
	
}
