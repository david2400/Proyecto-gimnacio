package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idClase;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Temporal(TemporalType.DATE)
	private Date horaFin;

	@Temporal(TemporalType.DATE)
	private Date horaInicio;

	private int idInstructor;

	private String nombre;

	@Column(name="sala_idsala")
	private int salaIdsala;

	//bi-directional many-to-one association to ClaseSala
	@OneToMany(mappedBy="clase")
	private List<ClaseSala> claseSalas;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="clase")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="clase")
	private List<SocioClase> socioClases;

	public Clase() {
	}

	public int getIdClase() {
		return this.idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Date getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getIdInstructor() {
		return this.idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSalaIdsala() {
		return this.salaIdsala;
	}

	public void setSalaIdsala(int salaIdsala) {
		this.salaIdsala = salaIdsala;
	}

	public List<ClaseSala> getClaseSalas() {
		return this.claseSalas;
	}

	public void setClaseSalas(List<ClaseSala> claseSalas) {
		this.claseSalas = claseSalas;
	}

	public ClaseSala addClaseSala(ClaseSala claseSala) {
		getClaseSalas().add(claseSala);
		claseSala.setClase(this);

		return claseSala;
	}

	public ClaseSala removeClaseSala(ClaseSala claseSala) {
		getClaseSalas().remove(claseSala);
		claseSala.setClase(null);

		return claseSala;
	}

	public List<InstructorClase> getInstructorClases() {
		return this.instructorClases;
	}

	public void setInstructorClases(List<InstructorClase> instructorClases) {
		this.instructorClases = instructorClases;
	}

	public InstructorClase addInstructorClas(InstructorClase instructorClas) {
		getInstructorClases().add(instructorClas);
		instructorClas.setClase(this);

		return instructorClas;
	}

	public InstructorClase removeInstructorClas(InstructorClase instructorClas) {
		getInstructorClases().remove(instructorClas);
		instructorClas.setClase(null);

		return instructorClas;
	}

	public List<SocioClase> getSocioClases() {
		return this.socioClases;
	}

	public void setSocioClases(List<SocioClase> socioClases) {
		this.socioClases = socioClases;
	}

	public SocioClase addSocioClas(SocioClase socioClas) {
		getSocioClases().add(socioClas);
		socioClas.setClase(this);

		return socioClas;
	}

	public SocioClase removeSocioClas(SocioClase socioClas) {
		getSocioClases().remove(socioClas);
		socioClas.setClase(null);

		return socioClas;
	}

}