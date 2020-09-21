package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the instructor_clase database table.
 * 
 */
@Entity
@Table(name="instructor_clase")
@NamedQuery(name="InstructorClase.findAll", query="SELECT i FROM InstructorClase i")
public class InstructorClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstructorClase;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="idClase")
	private Clase clase;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="idInstructor")
	private Instructor instructor;

	public InstructorClase() {
	}

	public int getIdInstructorClase() {
		return this.idInstructorClase;
	}

	public void setIdInstructorClase(int idInstructorClase) {
		this.idInstructorClase = idInstructorClase;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

}