package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the rutina database table.
 * 
 */
@Entity
@Data
@Table(name="rutina",schema="gimnasio")
@NamedQuery(name="Rutina.findAll", query="SELECT r FROM Rutina r")
public class Rutina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRutina;
	
	@NotBlank(message="Se te olvido Ingresar el nombre de la rutina")
	private String nombre;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="idInstructor")
	private Instructor instructor;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="idSocio")
	private Socio socio;

	//bi-directional many-to-one association to RutinaEjercicio
	@OneToMany(mappedBy="rutina")
	private List<RutinaEjercicio> rutinaEjercicios;

	

}