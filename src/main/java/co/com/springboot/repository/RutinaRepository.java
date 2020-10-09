package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Rutina;
@Repository
public interface RutinaRepository extends CrudRepository<Rutina,Integer> {

	@Query("select R from rutina R,socio S WHERE R.id_socio=S.idsocio AND id_socio=?1")
	public Rutina validarUsuario(@Param("id_socio") int idsocio);
	
}
