package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
	@NotBlank(message="Se te olvido Ingresar la cedula")
	private int cedula;

	private String correo;

	private String direccion;

	private String nombre;

	private String profesion;
	
	@NotBlank(message="Se te olvido Ingresar el usuario")
	private String usuario;

	@NotBlank(message="Se te olvido Ingresar la contraseña")
	private String password;
	
	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="socio")
	private List<Rutina> rutinas;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="socio")
	private List<SocioClase> socioClases;

	

}