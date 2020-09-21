package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSala;

	private String area;

	private String estado;

	private String foto;

	private String numeroSala;

	private String ubicacion;

	//bi-directional many-to-one association to ClaseSala
	@OneToMany(mappedBy="sala")
	private List<ClaseSala> claseSalas;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="sala")
	private List<Maquina> maquinas;

	//bi-directional many-to-one association to Tiposala
	@ManyToOne
	@JoinColumn(name="idTipoSala")
	private Tiposala tiposala;

	public Sala() {
	}

	public int getIdSala() {
		return this.idSala;
	}

	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public String getNumeroSala() {
		return this.numeroSala;
	}

	public void setNumeroSala(String numeroSala) {
		this.numeroSala = numeroSala;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<ClaseSala> getClaseSalas() {
		return this.claseSalas;
	}

	public void setClaseSalas(List<ClaseSala> claseSalas) {
		this.claseSalas = claseSalas;
	}

	public ClaseSala addClaseSala(ClaseSala claseSala) {
		getClaseSalas().add(claseSala);
		claseSala.setSala(this);

		return claseSala;
	}

	public ClaseSala removeClaseSala(ClaseSala claseSala) {
		getClaseSalas().remove(claseSala);
		claseSala.setSala(null);

		return claseSala;
	}

	public List<Maquina> getMaquinas() {
		return this.maquinas;
	}

	public void setMaquinas(List<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public Maquina addMaquina(Maquina maquina) {
		getMaquinas().add(maquina);
		maquina.setSala(this);

		return maquina;
	}

	public Maquina removeMaquina(Maquina maquina) {
		getMaquinas().remove(maquina);
		maquina.setSala(null);

		return maquina;
	}

	public Tiposala getTiposala() {
		return this.tiposala;
	}

	public void setTiposala(Tiposala tiposala) {
		this.tiposala = tiposala;
	}

}