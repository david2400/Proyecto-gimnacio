package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEjercicio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to RutinaEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<RutinaEjercicio> rutinaEjercicios;

	public Ejercicio() {
	}

	public int getIdEjercicio() {
		return this.idEjercicio;
	}

	public void setIdEjercicio(int idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<RutinaEjercicio> getRutinaEjercicios() {
		return this.rutinaEjercicios;
	}

	public void setRutinaEjercicios(List<RutinaEjercicio> rutinaEjercicios) {
		this.rutinaEjercicios = rutinaEjercicios;
	}

	public RutinaEjercicio addRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
		getRutinaEjercicios().add(rutinaEjercicio);
		rutinaEjercicio.setEjercicio(this);

		return rutinaEjercicio;
	}

	public RutinaEjercicio removeRutinaEjercicio(RutinaEjercicio rutinaEjercicio) {
		getRutinaEjercicios().remove(rutinaEjercicio);
		rutinaEjercicio.setEjercicio(null);

		return rutinaEjercicio;
	}

}