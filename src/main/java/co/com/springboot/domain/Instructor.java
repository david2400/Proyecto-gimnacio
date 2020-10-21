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
 * The persistent class for the instructor database table.
 * 
 */
@Entity
@Data
@Table(name="instructor",schema="gimnasio")

@NamedQuery(name="Instructor.findAll", query="SELECT i FROM Instructor i")
public class Instructor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstructor;

	@NotNull(message = "{error.campoObligatorio}")	
	private int cedula;
	
	@Size(min = 5, max = 100, message = "{error.usuario.telefono}")
	private String celular;
	
	@NotNull(message = "{error.campoObligatorio}")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="{error.usuario.correo}")
	private String correo;

	private String experienciaLaboral;

	private String foto;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message = "Se te olvido Insertar el nombre del administrador")
	@Pattern(regexp = "[A-Za-z ]+", message = "{error.sololetras}")
	private String nombre;

	private String preparacion;

	private String titulacion;

	@NotNull(message="Se te olvido Ingresar el usuario")
	private String usuario;
	
	@NotNull(message="Se te olvido Ingresar la contraseña")
	private String password;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="instructor")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="instructor")
	private List<Rutina> rutinas;

	

}