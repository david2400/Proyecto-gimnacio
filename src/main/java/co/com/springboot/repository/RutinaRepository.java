package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Rutina;
@Repository
public interface RutinaRepository extends CrudRepository<Rutina,Integer> {
	
	@Query("select r from Rutina r WHERE r.socio.idsocio= :idsocio")
	public Rutina validarUsuario(@Param("idsocio") Integer idsocio);
	
}
