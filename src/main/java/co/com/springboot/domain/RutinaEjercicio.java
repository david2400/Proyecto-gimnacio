package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;


/**
 * The persistent class for the rutina_ejercicio database table.
 * 
 */
@Entity
@Data
@Table(name="rutina_ejercicio",schema="gimnasio")
@NamedQuery(name="RutinaEjercicio.findAll", query="SELECT r FROM RutinaEjercicio r")
public class RutinaEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRutinaEjercicio;
	
	@NotNull(message="Se te olvido Ingresar la repeticiones del ejercicio")
	private int repeticiones;
	
	@NotNull(message="Se te olvido Ingresar el numero de series del ejercicio")
	private int series;
	
	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="idEjercicio")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Rutina
	@ManyToOne
	@JoinColumn(name="idRutina")
	private Rutina rutina;


}