/**
 * 
 */
package com.example.modelo;

/**
 * @author Diego
 *
 */
import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the administrador database table.
 * 
 */

@Entity
@Data

@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrador;

	private String cedula;

	private String celular;

	private String correo;

	private String foto;

	private String nombre;

	private String password;

	private String usuario;

	

}
