package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Socio;
@Repository
public interface SocioRepository extends CrudRepository<Socio,Integer>{
	@Query("select s from socio s where s.usuario= :usuario ")
	public Socio validarUsuario(@Param("usuario") String usuario);
	
	@Query("select s from socio s where s.cedula= :cedula")
	public Socio Buscar(@Param("cedula") int cedula);
	
	@Query("select s from socio s where s.usuario=:usuario AND s.password= :password")
	public Socio login(@Param("usuario") String usuario,@Param("password") String contrasena);
}
