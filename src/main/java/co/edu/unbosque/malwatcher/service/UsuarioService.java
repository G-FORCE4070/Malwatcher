package co.edu.unbosque.malwatcher.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.unbosque.malwatcher.model.Usuario;
import co.edu.unbosque.malwatcher.repository.UsuarioRepository;

/**
 * Servicio para gestionar las operaciones relacionadas con la entidad
 * {@link Usuario}.
 * <p>
 * La clase `UsuarioService` proporciona métodos para crear, actualizar, obtener
 * y validar usuarios en la aplicación. Utiliza el repositorio
 * {@link UsuarioRepository} para realizar las operaciones de persistencia.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepo;

	public UsuarioService() {
	}

	/**
	 * Crea y guarda un nuevo usuario en la base de datos.
	 *
	 * @param newUsuario el nuevo usuario a guardar.
	 */
	public void create(Usuario newUsuario) {
		usuarioRepo.save(newUsuario);
	}

	/**
	 * Obtiene un usuario por su nombre de usuario.
	 *
	 * @param userName el nombre de usuario.
	 * @return el usuario encontrado o `null` si no existe.
	 */
	public Usuario obtenerPorNombreUsuario(String userName) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findByNombreUsuario(userName);
		return usuarioOpt.orElse(null);
	}

	/**
	 * Obtiene todos los usuarios en la base de datos.
	 *
	 * @return una lista de todos los usuarios.
	 */
	public ArrayList<Usuario> getAll() {
		return (ArrayList<Usuario>) usuarioRepo.findAll();
	}

	/**
	 * Cuenta el número total de usuarios en la base de datos.
	 *
	 * @return el número total de usuarios.
	 */
	public long count() {
		return usuarioRepo.count();
	}

	/**
	 * Verifica si un usuario existe en la base de datos por su ID.
	 *
	 * @param id el ID del usuario.
	 * @return `true` si el usuario existe, `false` en caso contrario.
	 */
	public boolean exists(Integer id) {
		return usuarioRepo.existsById(id);
	}

	/**
	 * Actualiza un usuario en la base de datos con nuevos datos.
	 *
	 * @param id      el ID del usuario a actualizar.
	 * @param newData los nuevos datos del usuario.
	 * @return `0` si se actualizó correctamente, `1` si el nombre de usuario ya
	 *         está en uso, `2` si el usuario no existe, `3` si ocurre otro error.
	 */
	public int updateById(Integer id, Usuario newData) {
		Optional<Usuario> found = usuarioRepo.findById(id);
		Optional<Usuario> newFound = usuarioRepo.findById(id);
		if (found.isPresent() && !newFound.isPresent()) {
			Usuario usuarioTemp = found.get();
			usuarioTemp.setNombreUsuario(newData.getNombreUsuario());
			usuarioTemp.setCorreo(newData.getCorreo());
			usuarioTemp.setContrasenia(newData.getContrasenia());
			usuarioTemp.setCodigo(newData.getCodigo());
			usuarioRepo.save(usuarioTemp);
			return 0;
		}
		if (found.isPresent() && newFound.isPresent()) {
			return 1;
		}
		if (!found.isPresent()) {
			return 2;
		} else {
			return 3;
		}
	}

	/**
	 * Obtiene un usuario por su ID.
	 *
	 * @param id el ID del usuario.
	 * @return el usuario encontrado o `null` si no existe.
	 */
	public Usuario getById(Integer id) {
		Optional<Usuario> found = usuarioRepo.findById(id);
		if (found.isPresent()) {
			return found.get();
		} else {
			return null;
		}
	}

	/**
	 * Verifica si un nombre de usuario ya está en uso.
	 *
	 * @param newUser el usuario con el nombre a verificar.
	 * @return `true` si el nombre de usuario ya está en uso, `false` en caso
	 *         contrario.
	 */
	public boolean findUsernameAlreadyTaken(Usuario newUser) {
		Optional<Usuario> found = usuarioRepo.findByNombreUsuario(newUser.getNombreUsuario());
		if (found.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Obtiene un usuario por su nombre de usuario.
	 *
	 * @param username el nombre de usuario a buscar.
	 * @return el usuario encontrado o `null` si no existe.
	 */
	public Usuario obtenerUsuarioPorNombreDeUsuario(String username) {
		Optional<Usuario> usuarioOpt = usuarioRepo.findByNombreUsuario(username);
		return usuarioOpt.orElse(null); // Retorna null si el usuario no se encuentra
	}

	/**
	 * Valida las credenciales de inicio de sesión de un usuario.
	 *
	 * @param username el nombre de usuario.
	 * @param password la contraseña del usuario.
	 * @return `0` si las credenciales son correctas, `1` si son incorrectas.
	 */
	public int validateCredentials(String username, String password) {

		for (Usuario u : getAll()) {
			if (u.getNombreUsuario().equals(username)) {
				if (u.getContrasenia().equals(password)) {
					return 0;
				}
			}
		}
		return 1;
	}

	/**
	 * Agrega un archivo al historial de un usuario específico.
	 *
	 * @param userId el ID del usuario al que se agregará el archivo.
	 * @param sha256 el hash SHA-256 del archivo a agregar al historial.
	 */
	public void agregarArchivoAlHistorial(int userId, String sha256) {
		Usuario usuario = usuarioRepo.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

		// Verifica que se esté agregando correctamente al historial
		usuario.getHistorialArchivos().add(sha256);
		usuarioRepo.save(usuario); // Guarda el usuario con el historial actualizado
	}

	/**
	 * Obtiene el historial de archivos de un usuario específico.
	 *
	 * @param userId el ID del usuario cuyo historial se desea obtener.
	 * @return una lista de hashes SHA-256 de los archivos en el historial del
	 *         usuario.
	 */
	public List<String> obtenerHistorial(int userId) {
		Usuario usuario = usuarioRepo.findById(userId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		return usuario.getHistorialArchivos();
	}
}