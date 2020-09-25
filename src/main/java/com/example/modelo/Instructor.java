package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the instructor database table.
 * 
 */
@Entity
@Data

@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstructor;

	private String cedula;

	private String celular;

	private String correo;

	private String experienciaLaboral;

	private String foto;

	private String nombre;

	private String password;

	private String preparacion;

	private String titulacion;

	private String usuario;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="instructor")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="instructor")
	private List<Rutina> rutinas;

	

}