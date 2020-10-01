package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the socio database table.
 * 
 */
@Entity
@Data
@Table(name="socio",schema="gimnasio")
@NamedQuery(name="Socio.findAll", query="SELECT s FROM Socio s")
public class Socio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsocio;

	private int cedula;

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

	

}