package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import co.com.springboot.domain.Clase;
@Repository
public interface ClaseRepository  extends CrudRepository<Clase,Integer>{
	
	
	@Query("select c from InstructorClase ic,Clase c WHERE ic.clase.idClase=c.idClase AND ic.instructor.idInstructor= :idInstructor")
	public Iterable<Clase> InstructorClase(@Param("idInstructor") Integer idInstructor);
	
	
	
	
	
	
	
}
