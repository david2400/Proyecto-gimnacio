package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@Data

@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEjercicio;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to RutinaEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<RutinaEjercicio> rutinaEjercicios;


	

}