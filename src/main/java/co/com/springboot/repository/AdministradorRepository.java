package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Administrador;


@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,Integer>{
	@Query("select a from administrador a where a.usuario= :usuario")
	public Administrador validarUsuario(@Param("usuario") String usuario);
	
	@Query("select a from administrador a where a.cedula= :cedula")
	public Administrador Buscar(@Param("cedula") int cedula);
	
	@Query("select a from administrador a where a.usuario= :usuario AND a.password= :password")
	public Administrador login(@Param("usuario") String usuario,@Param("password") String contrasena);
}
