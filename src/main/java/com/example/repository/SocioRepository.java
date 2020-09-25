package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.modelo.Socio;
@Repository
public interface SocioRepository extends CrudRepository<Socio,Integer>{
	@Query("select s from socio s where s.usuario=?1")
	public Socio validarUsuario(String usuario);
	
	@Query("select s from socio s where s.cedula=?1")
	public Socio Buscar(String cedula);
	
	@Query("select s from socio s where s.usuario=?1 AND s.password=?2")
	public Socio login(String usuario,String contrasena);
}
