package co.com.springboot.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Ejercicio;
@Repository
public interface EjercicioRepository  extends CrudRepository<Ejercicio,Integer>{
	
	@Query("select E from ejercicio E JOIN rutina_ejercicio RE ON RE.id_ejercicio=E.id_ejercicio JOIN rutina R ON RE.id_rutina=R.id_rutina"
			+ " where R.id_rutina=?1")
	public ArrayList<Ejercicio>  ClaseSocio(String idRutina);
	
}
