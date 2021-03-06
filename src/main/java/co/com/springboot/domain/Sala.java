package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@Data
@Table(name="sala",schema="gimnasio")
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSala;

	private String area;

	private String estado;
	
	@NotNull(message="Se te olvido a�adir la foto de la sala")
	private String foto;

	@NotNull(message="Se te olvido Ingresar el numero de la sala")
	private String numeroSala;

	private String ubicacion;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="sala")
	private List<Maquina> maquinas;

	//bi-directional many-to-one association to Tiposala
	@ManyToOne
	@JoinColumn(name="idTipoSala")
	private Tiposala tiposala;

	public Sala() {
		super();
	}

	

	
}