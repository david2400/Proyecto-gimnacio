package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;



/**
 * The persistent class for the instructor_clase database table.
 * 
 */
@Entity
@Data
@Table(name="instructor_clase",schema="gimnasio")
@NamedQuery(name="InstructorClase.findAll", query="SELECT i FROM InstructorClase i")
public class InstructorClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idInstructorClase;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	@JoinColumn(name="idClase")
	private Clase clase;

	//bi-directional many-to-one association to Instructor
	@ManyToOne
	@JoinColumn(name="idInstructor")
	private Instructor instructor;


}