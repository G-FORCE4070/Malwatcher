package co.edu.unbosque.malwatcher.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Clase `Usuario` que representa un usuario en la aplicación MalWatcher.
 * <p>
 * Esta clase define la estructura de la entidad `Usuario`, que se mapea a la
 * tabla `usuario` en la base de datos. Incluye atributos como el nombre de
 * usuario, correo electrónico, contraseña y un código de verificación. También
 * almacena un historial de archivos subidos, representado por una lista de
 * hashes SHA-256 de cada archivo.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * Identificador único del usuario.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * Nombre de usuario (único y obligatorio).
	 */
	@Column(name = "nombreusuario", nullable = false, unique = true)
	private String nombreUsuario;

	/**
	 * Correo electrónico del usuario (único y obligatorio).
	 */
	@Column(name = "correo", nullable = false, unique = true)
	private String correo;

	/**
	 * Contraseña del usuario (obligatoria).
	 */
	@Column(name = "contrasenia", nullable = false)
	private String contrasenia;

	/**
	 * Código de verificación del usuario.
	 */
	@Column(name = "codigo")
	private String codigo;

	/**
	 * Historial de archivos subidos por el usuario, representado como una lista de
	 * hashes SHA-256.
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> historialArchivos = new ArrayList<>();

	/**
	 * Obtiene el historial de archivos del usuario.
	 *
	 * @return Lista de hashes SHA-256 de los archivos en el historial.
	 */
	public List<String> getHistorialArchivos() {
		return historialArchivos;
	}

	/**
	 * Establece el historial de archivos del usuario.
	 *
	 * @param historialArchivos Lista de hashes SHA-256 para asignar al historial.
	 */
	public void setHistorialArchivos(List<String> historialArchivos) {
		this.historialArchivos = historialArchivos;
	}

	/**
	 * Constructor por defecto.
	 */
	public Usuario() {
	}

	/**
	 * Constructor con todos los atributos.
	 *
	 * @param id                Identificador único del usuario.
	 * @param nombreUsuario     Nombre de usuario.
	 * @param correo            Correo electrónico del usuario.
	 * @param contrasenia       Contraseña del usuario.
	 * @param codigo            Código de verificación del usuario.
	 * @param historialArchivos Historial de archivos subidos.
	 */
	public Usuario(int id, String nombreUsuario, String correo, String contrasenia, String codigo,
			List<String> historialArchivos) {
		super();
		this.id = id;
		this.nombreUsuario = nombreUsuario;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.codigo = codigo;
		this.historialArchivos = historialArchivos;
	}

	// Getters y setters de los atributos básicos

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreUsuario=" + nombreUsuario + ", correo=" + correo + ", contrasenia="
				+ contrasenia + ", codigo=" + codigo + "]";
	}
}
