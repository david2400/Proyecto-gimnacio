package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.Administrador;


@Repository
public interface AdministracionRepository extends CrudRepository<Administrador,Integer>{
	@Query("select a from administrador a where a.usuario=?1")
	public Administrador validarUsuario(String usuario);
	
	@Query("select a from administrador a where a.cedula=?1")
	public Administrador Buscar(String cedula);
	
	@Query("select a from administrador a where a.usuario=?1 AND a.password=?2")
	public Administrador login(String usuario,String contrasena);
}
