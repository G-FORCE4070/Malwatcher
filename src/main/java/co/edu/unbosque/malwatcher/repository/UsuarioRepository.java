package co.edu.unbosque.malwatcher.repository;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import co.edu.unbosque.malwatcher.model.Usuario;

/**
 * Repositorio para gestionar operaciones de acceso a datos de la entidad
 * {@link Usuario}.
 * <p>
 * La interfaz `UsuarioRepository` extiende {@link CrudRepository} para
 * proporcionar métodos CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad
 * `Usuario`. Además, define un método personalizado para buscar usuarios por
 * nombre de usuario.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
	/**
	 * Busca un usuario en la base de datos por su nombre de usuario.
	 *
	 * @param userName el nombre de usuario a buscar.
	 * @return un {@link Optional} que contiene el usuario si es encontrado, o vacío
	 *         si no existe.
	 */
	public Optional<Usuario> findByNombreUsuario(String userName);

}