package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the maquinas database table.
 * 
 */
@Entity
@Table(name="maquinas")
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaquinas;

	private String codigo;

	private String descripcion;

	private String estado;

	private String foto;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;

	public Maquina() {
	}

	public int getIdMaquinas() {
		return this.idMaquinas;
	}

	public void setIdMaquinas(int idMaquinas) {
		this.idMaquinas = idMaquinas;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}