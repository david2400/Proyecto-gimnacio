package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import co.com.springboot.domain.Clase;
@Repository
public interface ClaseRepository  extends CrudRepository<Clase,Integer>{
	
	@Query("select C from clase C, socio_clase SC, socio S WHERE SC.clase_id_clase=C.id_clase AND S.idsocio=SC.id_socio AND sysdate<=fecha S.idsocio= :idsocio")
	public Iterable<Clase> SocioClase(@Param("idsocio") int idSocio);
	
	@Query("select C from clase C, instructor_clase IC, instructor i WHERE IC.id_clase=C.id_clase AND I.id_instructor=IC.id_instructor AND sysdate<=fecha S.idsocio= :id_instructor")
	public Iterable<Clase> InstructorClase(@Param("id_instructor") int idInstructor);
	
	
	
	
	
	
	
}
