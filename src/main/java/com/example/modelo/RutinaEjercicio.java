package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rutina_ejercicio database table.
 * 
 */
@Entity
@Table(name="rutina_ejercicio")
@NamedQuery(name="RutinaEjercicio.findAll", query="SELECT r FROM RutinaEjercicio r")
public class RutinaEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRutinaEjercicio;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="idEjercicio")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Rutina
	@ManyToOne
	@JoinColumn(name="idRutina")
	private Rutina rutina;

	public RutinaEjercicio() {
	}

	public int getIdRutinaEjercicio() {
		return this.idRutinaEjercicio;
	}

	public void setIdRutinaEjercicio(int idRutinaEjercicio) {
		this.idRutinaEjercicio = idRutinaEjercicio;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Rutina getRutina() {
		return this.rutina;
	}

	public void setRutina(Rutina rutina) {
		this.rutina = rutina;
	}

}