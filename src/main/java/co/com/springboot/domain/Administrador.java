/**
 * 
 */
package co.com.springboot.domain;

/**
 * @author Diego
 *
 */
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
	
	@NotBlank(message="Se te olvido Ingresar la cedula")	
	private int cedula;
	
	@NotBlank(message="Se te olvido Ingresar el celular")
	private String celular;

	private String correo;

	private String foto;

	private String nombre;
	
	@NotBlank(message="Se te olvido Ingresar la contraseña")
	private String password;
	
	@NotBlank(message="Se te olvido Ingresar el usuario")
	private String usuario;

	

}
