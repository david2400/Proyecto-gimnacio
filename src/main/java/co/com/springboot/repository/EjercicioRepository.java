package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Ejercicio;
@Repository
public interface EjercicioRepository  extends CrudRepository<Ejercicio,Integer>{
	
	@Query("select e from RutinaEjercicio re JOIN Ejercicio e ON re.ejercicio.idEjercicio=e.idEjercicio WHERE re.rutina.idRutina= :idRutina")
	public Iterable<Ejercicio>  EjercicioRutina(@Param("idRutina") Integer idRutina);
	
}
