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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;


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
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar la cedula")	
	private int cedula;
	
	@Size(min = 5, max = 100, message = "{error.usuario.telefono}")
	@NotNull(message = "{error.campoObligatorio}")
	private String celular;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar el correo")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message="{error.usuario.correo}")
	private String correo;

	private String foto;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message = "Se te olvido Insertar el nombre del administrador")
	@Pattern(regexp = "[A-Za-z ]+", message = "{error.sololetras}")
	private String nombre;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar el usuario")
	private String usuario;
	
	@NotNull(message = "{error.campoObligatorio}")
	@NotBlank(message="Se te olvido Ingresar la contraseña")
	private String password;
	
	

	

}
