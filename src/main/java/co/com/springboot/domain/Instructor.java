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

	public Instructor() {
		super();
	}
	
	public Instructor(int idInstructor, @NotNull(message = "{error.campoObligatorio}") int cedula,
			@Size(min = 5, max = 100, message = "{error.usuario.telefono}") String celular,
			@NotNull(message = "{error.campoObligatorio}") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{error.usuario.correo}") String correo,
			String experienciaLaboral, String foto,
			@NotNull(message = "{error.campoObligatorio}") @NotBlank(message = "Se te olvido Insertar el nombre del administrador") @Pattern(regexp = "[A-Za-z ]+", message = "{error.sololetras}") String nombre,
			String preparacion, String titulacion,
			@NotNull(message = "Se te olvido Ingresar el usuario") String usuario,
			@NotNull(message = "Se te olvido Ingresar la contraseña") String password,
			List<InstructorClase> instructorClases, List<Rutina> rutinas) {
		super();
		this.idInstructor = idInstructor;
		this.cedula = cedula;
		this.celular = celular;
		this.correo = correo;
		this.experienciaLaboral = experienciaLaboral;
		this.foto = foto;
		this.nombre = nombre;
		this.preparacion = preparacion;
		this.titulacion = titulacion;
		this.usuario = usuario;
		this.password = password;
		this.instructorClases = instructorClases;
		this.rutinas = rutinas;
	}

	public int getIdInstructor() {
		return idInstructor;
	}

	public void setIdInstructor(int idInstructor) {
		this.idInstructor = idInstructor;
	}

	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPreparacion() {
		return preparacion;
	}

	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}

	public String getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(String titulacion) {
		this.titulacion = titulacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<InstructorClase> getInstructorClases() {
		return instructorClases;
	}

	public void setInstructorClases(List<InstructorClase> instructorClases) {
		this.instructorClases = instructorClases;
	}

	public List<Rutina> getRutinas() {
		return rutinas;
	}

	public void setRutinas(List<Rutina> rutinas) {
		this.rutinas = rutinas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}