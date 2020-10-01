package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Administrador;


@Repository
public interface AdministradorRepository extends CrudRepository<Administrador,Integer>{
	@Query("select a from administrador a where a.usuario=?1")
	public Administrador validarUsuario(String usuario);
	
	@Query("select a from administrador a where a.cedula=?1")
	public Administrador Buscar(int cedula);
	
	@Query("select a from administrador a where a.usuario=?1 AND a.password=?2")
	public Administrador login(String usuario,String contrasena);
}
