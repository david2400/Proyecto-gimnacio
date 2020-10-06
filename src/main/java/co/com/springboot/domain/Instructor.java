package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

	private int cedula;

	private String celular;

	private String correo;

	private String experienciaLaboral;

	private String foto;

	private String nombre;

	private String preparacion;

	private String titulacion;

	@NotBlank(message="Se te olvido Ingresar el usuario")
	private String usuario;
	
	@NotBlank(message="Se te olvido Ingresar la contraseña")
	private String password;

	//bi-directional many-to-one association to InstructorClase
	@OneToMany(mappedBy="instructor")
	private List<InstructorClase> instructorClases;

	//bi-directional many-to-one association to Rutina
	@OneToMany(mappedBy="instructor")
	private List<Rutina> rutinas;

	

}