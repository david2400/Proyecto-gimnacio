package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the socio_clase database table.
 * 
 */
@Entity
@Table(name="socio_clase")
@NamedQuery(name="SocioClase.findAll", query="SELECT s FROM SocioClase s")
public class SocioClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSocioClase;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	private Clase clase;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="idSocio")
	private Socio socio;

	public SocioClase() {
	}

	public int getIdSocioClase() {
		return this.idSocioClase;
	}

	public void setIdSocioClase(int idSocioClase) {
		this.idSocioClase = idSocioClase;
	}

	public Clase getClase() {
		return this.clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Socio getSocio() {
		return this.socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

}