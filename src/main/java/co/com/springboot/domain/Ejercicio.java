package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@Data
@Table(name="ejercicio",schema="gimnasio")
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEjercicio;

	private String descripcion;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar el nombre del ejercicio")
	private String nombre;

	//bi-directional many-to-one association to RutinaEjercicio
	@NotNull(message = "{error.campoObligatorio}")
	@OneToMany(mappedBy="ejercicio")
	private List<RutinaEjercicio> rutinaEjercicios;

	public Ejercicio() {
		super();
	}


	

}