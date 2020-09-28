package co.com.springboot.domain;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;


/**
 * The persistent class for the socio_clase database table.
 * 
 */
@Entity
@Data
@Table(name="socio_clase",schema="gimnasio")
@NamedQuery(name="SocioClase.findAll", query="SELECT s FROM SocioClase s")
public class SocioClase implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSocioClase;

	//bi-directional many-to-one association to Clase
	@ManyToOne
	private Clase clase;

	//bi-directional many-to-one association to Socio
	@ManyToOne
	@JoinColumn(name="idSocio")
	private Socio socio;

	

}