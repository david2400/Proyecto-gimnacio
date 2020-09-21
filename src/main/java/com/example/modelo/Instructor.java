package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instructor database table.
 * 
 */
@Entity
@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstructor;

	private String cedula;

	private String celular;

	private String correo;

	private String experienciaLaboral;

	private String foto;

	private String nombre;

	private String password;

	private String preparacion;

	private String titulacion;

	private String usuario;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="instructor")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="instructor")
	private List<Rutina> rutinas;

	public Instructor() {
	}

	public int getIdInstructor() {
		return this.idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getExperienciaLaboral() {
		return this.experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreparacion() {
		return this.preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getTitulacion() {
		return this.titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<InstructorClase> getInstructorClases() {
		return this.instructorClases;
	}

	public void setInstructorClases(List<InstructorClase> instructorClases) {
		this.instructorClases = instructorClases;
	}

	public InstructorClase addInstructorClas(InstructorClase instructorClas) {
		getInstructorClases().add(instructorClas);
		instructorClas.setInstructor(this);

		return instructorClas;
	}

	public InstructorClase removeInstructorClas(InstructorClase instructorClas) {
		getInstructorClases().remove(instructorClas);
		instructorClas.setInstructor(null);

		return instructorClas;
	}

	public List<Rutina> getRutinas() {
		return this.rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public Rutina addRutina(Rutina rutina) {
		getRutinas().add(rutina);
		rutina.setInstructor(this);

		return rutina;
	}

	public Rutina removeRutina(Rutina rutina) {
		getRutinas().remove(rutina);
		rutina.setInstructor(null);

		return rutina;
	}

}