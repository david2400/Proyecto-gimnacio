package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tiposala database table.
 * 
 */
@Entity
@NamedQuery(name="Tiposala.findAll", query="SELECT t FROM Tiposala t")
public class Tiposala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTipoSala;

	private String nombre;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="tiposala")
	private List<Sala> salas;

	public Tiposala() {
	}

	public int getIdTipoSala() {
		return this.idTipoSala;
	}

	public void setIdTipoSala(int idTipoSala) {
		this.idTipoSala = idTipoSala;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Sala addSala(Sala sala) {
		getSalas().add(sala);
		sala.setTiposala(this);

		return sala;
	}

	public Sala removeSala(Sala sala) {
		getSalas().remove(sala);
		sala.setTiposala(null);

		return sala;
	}

}