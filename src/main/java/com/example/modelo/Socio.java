package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the socio database table.
 * 
 */
@Entity
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsocio;

	private String cedula;

	private String correo;

	private String dirrecion;

	private String nombre;

	private String password;

	private String profecion;

	private String usuario;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="socio")
	private List<Rutina> rutinas;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="socio")
	private List<SocioClase> socioClases;

	public Socio() {
	}

	public int getIdsocio() {
		return this.idsocio;
	}

	public void setIdsocio(int idsocio) {
		this.idsocio = idsocio;
	}

	public String getCedula() {
		return this.cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDirrecion() {
		return this.dirrecion;
	}

	public void setDirrecion(String dirrecion) {
		this.dirrecion = dirrecion;
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

	public String getProfecion() {
		return this.profecion;
	}

	public void setProfecion(String profecion) {
		this.profecion = profecion;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Rutina> getRutinas() {
		return this.rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public Rutina addRutina(Rutina rutina) {
		getRutinas().add(rutina);
		rutina.setSocio(this);

		return rutina;
	}

	public Rutina removeRutina(Rutina rutina) {
		getRutinas().remove(rutina);
		rutina.setSocio(null);

		return rutina;
	}

	public List<SocioClase> getSocioClases() {
		return this.socioClases;
	}

	public void setSocioClases(List<SocioClase> socioClases) {
		this.socioClases = socioClases;
	}

	public SocioClase addSocioClas(SocioClase socioClas) {
		getSocioClases().add(socioClas);
		socioClas.setSocio(this);

		return socioClas;
	}

	public SocioClase removeSocioClas(SocioClase socioClas) {
		getSocioClases().remove(socioClas);
		socioClas.setSocio(null);

		return socioClas;
	}

}