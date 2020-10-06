package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Rutina;
@Repository
public interface RutinaRepository extends CrudRepository<Rutina,Integer> {

	@Query("select R from rutina R JOIN socio S ON R.id_socio=S.idsocio WHERE id_socio=?1")
	public Rutina validarUsuario(int idsocio);
	
}
