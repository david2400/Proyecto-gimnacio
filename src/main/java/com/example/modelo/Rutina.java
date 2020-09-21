package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the rutina database table.
 * 
 */
@Entity
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRutina;

	private String nombre;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="idInstructor")
	private Instructor instructor;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="idSocio")
	private Socio socio;

	//bi-directional many-to-one association to RutinaEjercicio
	@OneToMany(mappedBy="rutina")
	private List<RutinaEjercicio> rutinaEjercicios;

	public Rutina() {
	}

	public int getIdRutina() {
		return this.idRutina;
	}

	public void setIdRutina(int idRutina) {
		this.idRutina = idRutina;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Instructor getInstructor() {
		return this.instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public List<RutinaEjercicio> getRutinaEjercicios() {
		return this.rutinaEjercicios;
	}

	public void setRutinaEjercicios(List<RutinaEjercicio> rutinaEjercicios) {
		this.rutinaEjercicios = rutinaEjercicios;
	}

	public RutinaEjercicio addRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
		getRutinaEjercicios().add(rutinaEjercicio);
		rutinaEjercicio.setRutina(this);

		return rutinaEjercicio;
	}

	public RutinaEjercicio removeRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
		getRutinaEjercicios().remove(rutinaEjercicio);
		rutinaEjercicio.setRutina(null);

		return rutinaEjercicio;
	}

}