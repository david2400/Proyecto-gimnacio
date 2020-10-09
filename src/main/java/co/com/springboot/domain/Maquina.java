package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;



/**
 * The persistent class for the maquinas database table.
 * 
 */
@Entity
@Data

@Table(name="maquinas",schema="gimnasio")
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaquinas;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar el codigo")
	private String codigo;
	
	@NotNull(message = "{error.campoObligatorio}")	
	@NotBlank(message="Se te olvido Ingresar el nombre")
	private String nombre;	

	private String descripcion;

	private String estado;

	@NotBlank(message="Se te olvido añadir la foto de la maquina")
	private String foto;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;

	
}