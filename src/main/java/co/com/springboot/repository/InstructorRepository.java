package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	@Query("select I from Instructor I where I.usuario= :usuario")
	public Instructor validarUsuario(@Param("usuario") String usuario);
	
	@Query("select I from Instructor I where I.cedula= :cedula")
	public Instructor Buscar(@Param("cedula") Integer cedula);
	
	@Query("select I from Instructor I where I.usuario= :usuario AND I.password= :password")
	public Instructor login(@Param("usuario") String usuario,@Param("password") String contrasena);
}
