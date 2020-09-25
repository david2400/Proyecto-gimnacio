package com.example.modelo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;



/**
 * The persistent class for the maquinas database table.
 * 
 */
@Entity
@Data

@Table(name="maquinas")
@NamedQuery(name="Maquina.findAll", query="SELECT m FROM Maquina m")
public class Maquina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMaquinas;

	private String codigo;

	private String descripcion;

	private String estado;

	private String foto;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="idSala")
	private Sala sala;

	
}