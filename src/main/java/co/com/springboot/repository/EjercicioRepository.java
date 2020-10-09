package co.com.springboot.repository;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Ejercicio;
@Repository
public interface EjercicioRepository  extends CrudRepository<Ejercicio,Integer>{
	
	@Query("select E from ejercicio E, rutina_ejercicio RE, rutina R "
			+ " WHERE RE.id_ejercicio=E.id_ejercicio AND RE.id_rutina=R.id_rutina AND R.id_rutina= :id_rutina")
	public Iterable<Ejercicio>  ClaseSocio(@Param("id_rutina") String idRutina);
	
}
