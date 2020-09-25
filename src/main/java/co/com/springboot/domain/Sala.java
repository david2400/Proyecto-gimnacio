package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


/**
 * The persistent class for the sala database table.
 * 
 */
@Entity
@Data
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSala;

	private String area;

	private String estado;

	private String foto;

	private String numeroSala;

	private String ubicacion;

	//bi-directional many-to-one association to ClaseSala
	@OneToMany(mappedBy="sala")
	private List<ClaseSala> claseSalas;

	//bi-directional many-to-one association to Maquina
	@OneToMany(mappedBy="sala")
	private List<Maquina> maquinas;

	//bi-directional many-to-one association to Tiposala
	@ManyToOne
	@JoinColumn(name="idTipoSala")
	private Tiposala tiposala;


}