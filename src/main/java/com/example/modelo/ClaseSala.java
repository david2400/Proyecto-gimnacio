package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clase_sala database table.
 * 
 */
@Entity
@Table(name="clase_sala")
@NamedQuery(name="ClaseSala.findAll", query="SELECT c FROM ClaseSala c")
public class ClaseSala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClaseSala;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="idClase")
	private Clase clase;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;

	public ClaseSala() {
	}

	public int getIdClaseSala() {
		return this.idClaseSala;
	}

	public void setIdClaseSala(int idClaseSala) {
		this.idClaseSala = idClaseSala;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}