package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.springboot.domain.Instructor;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor,Integer> {
	@Query("select I from instructor I where I.usuario=?1")
	public Instructor validarUsuario(String usuario);
	
	@Query("select I from instructor I where I.cedula=?1")
	public Instructor Buscar(String cedula);
	
	@Query("select I from instructor I where I.usuario=?1 AND I.password=?2")
	public Instructor login(String usuario,String contrasena);
}
