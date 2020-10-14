package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
	
	@Size(min = 5, max = 100, message = "{error.socio.celular}")
	@NotBlank(message="Se te olvido Ingresar la cedula")
	private int cedula;

	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="{error.usuario.correo}")
	private String correo;

	private String direccion;

	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message = "Se te olvido Insertar la nombre")
	@Pattern(regexp = "[A-Za-z ]+", message = "{error.sololetras}")
	private String nombre;

	private String profesion;
	
	@NotBlank(message="Se te olvido Ingresar el usuario")
	private String usuario;

	@NotNull(message="Se te olvido Ingresar la contraseña")
	private String password;
	
	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="socio")
	private List<Rutina> rutinas;

	//bi-directional many-to-one association to SocioClase
	@OneToMany(mappedBy="socio")
	private List<SocioClase> socioClases;

	

}