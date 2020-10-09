package co.com.springboot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	@Query("select I from instructor I where I.usuario= :usuario")
	public Instructor validarUsuario(@Param("usuario") String usuario);
	
	@Query("select I from instructor I where I.cedula=")
	public Instructor Buscar(@Param("cedula") int cedula);
	
	@Query("select I from instructor I where I.usuario=?1 AND I.password=?2")
	public Instructor login(@Param("usuario") String usuario,@Param("password") String contrasena);
}
