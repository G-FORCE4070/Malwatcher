package co.edu.unbosque.malwatcher.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.unbosque.malwatcher.model.Usuario;
import co.edu.unbosque.malwatcher.service.UsuarioService;
import co.edu.unbosque.malwatcher.util.MailSender;

/**
 * Controlador REST para gestionar las operaciones relacionadas con los usuarios
 * en la aplicación Malwatcher.
 * <p>
 * Proporciona endpoints para crear, verificar, actualizar y autenticar
 * usuarios. También permite obtener información sobre los usuarios, como listar
 * todos los usuarios o contar el número de usuarios registrados.
 * </p>
 * <p>
 * La clase está anotada con {@link CrossOrigin} para permitir el acceso desde
 * orígenes externos.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" })
@Transactional
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioServ;

	public UsuarioController() {
	}

	/**
	 * Crea un nuevo usuario a partir de un objeto JSON.
	 *
	 * @param newUsuario el objeto JSON que representa al nuevo usuario.
	 * @return una respuesta indicando el éxito de la creación.
	 */
	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> createNewWithJSON(@RequestBody Usuario newUsuario) {
		usuarioServ.create(newUsuario);
		return new ResponseEntity<String>("{persona creada con exito}", HttpStatus.CREATED);
	}

	/**
	 * Genera un código de verificación aleatorio de 6 caracteres.
	 *
	 * @return el código de verificación generado.
	 */
	private String generarCodigoVerificacion() {
		return UUID.randomUUID().toString().substring(0, 6);
	}

	/**
	 * Crea un nuevo usuario y envía un correo de verificación con un código de
	 * verificación.
	 *
	 * @param nombreUsuario el nombre de usuario.
	 * @param correo        el correo electrónico del usuario.
	 * @param contrasenia   la contraseña del usuario.
	 * @return una respuesta indicando el resultado del envío del correo de
	 *         verificación.
	 */
	@PostMapping(path = "/create")
	public ResponseEntity<String> createNew(@RequestParam String nombreUsuario, @RequestParam String correo,
			@RequestParam String contrasenia) {
		// Generar el código de verificación
		String generatedCodigoVerificacion = generarCodigoVerificacion();

		// Enviar el correo de verificación con el código generado
		boolean emailSent = MailSender.sendEmail(correo, nombreUsuario, contrasenia, generatedCodigoVerificacion);

		if (emailSent) {
			// Almacenar el código temporalmente en algún lugar accesible para la próxima
			// verificación
			CodigoVerificacionStorage.almacenarCodigo(correo, generatedCodigoVerificacion);
			return new ResponseEntity<>("Correo de verificación enviado con éxito. Confirma tu cuenta.",
					HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Error al enviar correo de verificación.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Verifica el código de verificación proporcionado por el usuario y crea el
	 * usuario si el código es correcto.
	 *
	 * @param nombreUsuario      el nombre de usuario.
	 * @param correo             el correo electrónico del usuario.
	 * @param contrasenia        la contraseña del usuario.
	 * @param codigoVerificacion el código de verificación proporcionado.
	 * @return una respuesta indicando si la verificación fue exitosa.
	 */
	@PostMapping(path = "/verify")
	public ResponseEntity<String> verify(@RequestParam String nombreUsuario, @RequestParam String correo,
			@RequestParam String contrasenia, @RequestParam String codigoVerificacion) {
		// Obtener el código almacenado para el correo dado
		String storedCodigo = CodigoVerificacionStorage.obtenerCodigo(correo);

		if (storedCodigo == null) {
			return new ResponseEntity<>("No se encontró un código de verificación para este usuario.",
					HttpStatus.NOT_FOUND);
		}

		// Comparar el código almacenado con el proporcionado
		if (storedCodigo.equals(codigoVerificacion)) {
			// Código correcto: crear el usuario de forma definitiva
			Usuario newUsuario = new Usuario(0, nombreUsuario, correo, contrasenia, codigoVerificacion,
					new ArrayList<>());
			usuarioServ.create(newUsuario); // Guardar el usuario en la base de datos
			CodigoVerificacionStorage.eliminarCodigo(correo); // Eliminar el código ya usado
			return new ResponseEntity<>("Cuenta verificada y usuario creado con éxito.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Código de verificación incorrecto.", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Valida las credenciales de inicio de sesión del usuario.
	 *
	 * @param nombreUsuario el nombre de usuario.
	 * @param contrasenia   la contraseña del usuario.
	 * @return una respuesta indicando si las credenciales son correctas.
	 */
	@PostMapping(path = "/checklogin")
	ResponseEntity<String> checkLogIn(@RequestParam String nombreUsuario, @RequestParam String contrasenia) {
		int status = usuarioServ.validateCredentials(nombreUsuario, contrasenia);

		if (status == 0) {
			return new ResponseEntity<>("Correct credendials", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Usuarioname or password incorrect", HttpStatus.UNAUTHORIZED);
		}
	}

	/**
	 * Obtiene la lista de todos los usuarios registrados.
	 *
	 * @return una respuesta con la lista de usuarios.
	 */
	@GetMapping("/getall")
	ResponseEntity<List<Usuario>> getAll() {
		List<Usuario> usuarios = usuarioServ.getAll();
		if (usuarios.isEmpty()) {
			return new ResponseEntity<>(usuarios, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(usuarios, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * Cuenta el número de usuarios registrados.
	 *
	 * @return una respuesta con el número de usuarios registrados.
	 */
	@GetMapping("/count")
	ResponseEntity<Long> countAll() {
		Long count = usuarioServ.count();
		if (count == 0) {
			return new ResponseEntity<>(count, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(count, HttpStatus.ACCEPTED);
		}
	}

	/**
	 * Verifica si existe un usuario con el ID proporcionado.
	 *
	 * @param id el ID del usuario.
	 * @return una respuesta indicando si el usuario existe.
	 */
	@GetMapping("/exists/{id}")
	ResponseEntity<Boolean> exists(@PathVariable Integer id) {
		boolean found = usuarioServ.exists(id);
		if (found) {
			return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * Obtiene un usuario por su ID.
	 *
	 * @param id ID del usuario.
	 * @return ResponseEntity con el usuario encontrado o null si no se encuentra y
	 *         el estado HTTP correspondiente.
	 */
	@GetMapping("/getbyid/{id}")
	ResponseEntity<Usuario> getById(@PathVariable Integer id) {
		Usuario found = usuarioServ.getById(id);
		if (found != null) {
			return new ResponseEntity<>(found, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Actualiza un usuario utilizando un objeto JSON en el cuerpo de la solicitud.
	 *
	 * @param id         ID del usuario a actualizar.
	 * @param newUsuario objeto Usuario con la nueva información.
	 * @return ResponseEntity con mensaje de éxito o error y el estado HTTP
	 *         correspondiente.
	 */
	@PutMapping(path = "/updatejson", consumes = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<String> updateNewWithJSON(@RequestParam Integer id, @RequestBody Usuario newUsuario) {

		int status = usuarioServ.updateById(id, newUsuario);

		if (status == 0) {
			return new ResponseEntity<>("Usuario updated successfully", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("New Usuarioname already taken", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Usuario not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Actualiza un usuario utilizando parámetros en la solicitud.
	 *
	 * @param id               ID del usuario a actualizar.
	 * @param newNombreUsuario nuevo nombre de usuario.
	 * @param newCorreo        nuevo correo electrónico.
	 * @param newPassword      nueva contraseña.
	 * @param newCodigo        nuevo código de verificación.
	 * @return ResponseEntity con mensaje de éxito o error y el estado HTTP
	 *         correspondiente.
	 */
	@PutMapping(path = "/update")
	ResponseEntity<String> updateNew(@RequestParam Integer id, @RequestParam String newNombreUsuario,
			@RequestParam String newCorreo, @RequestParam String newPassword, @RequestParam String newCodigo) {
		Usuario newUsuario = new Usuario(0, newNombreUsuario, newCorreo, newPassword, newCodigo, new ArrayList<>());

		int status = usuarioServ.updateById(id, newUsuario);

		if (status == 0) {
			return new ResponseEntity<>("Usuario updated successfully", HttpStatus.ACCEPTED);
		} else if (status == 1) {
			return new ResponseEntity<>("New Usuarioname already taken", HttpStatus.IM_USED);
		} else if (status == 2) {
			return new ResponseEntity<>("Usuario not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>("Error on update", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Agrega un archivo al historial de un usuario específico.
	 * <p>
	 * Este método permite agregar el hash `sha256` de un archivo al historial del
	 * usuario identificado por su `userId`. Se espera que el `sha256` proporcionado
	 * represente el hash único del archivo que será asociado al historial del
	 * usuario.
	 * </p>
	 *
	 * @param userId Identificador único del usuario al cual se agregará el archivo
	 *               al historial.
	 * @param sha256 Hash SHA-256 del archivo que se desea agregar al historial del
	 *               usuario.
	 * @return `ResponseEntity<Void>` con el código de respuesta HTTP 200 (OK) si la
	 *         operación se realiza con éxito.
	 */
	@PostMapping("/{userId}/historial")
	public ResponseEntity<Void> agregarArchivoAlHistorial(@PathVariable int userId, @RequestBody String sha256) {
		usuarioServ.agregarArchivoAlHistorial(userId, sha256);
		return ResponseEntity.ok().build();
	}

	/**
	 * Obtiene el historial de archivos de un usuario específico.
	 * <p>
	 * Este método permite recuperar el historial de archivos asociados al usuario
	 * identificado por su `userId`. El historial se devuelve como una lista de
	 * hashes SHA-256, donde cada hash representa un archivo que ha sido registrado
	 * en el historial del usuario.
	 * </p>
	 *
	 * @param userId Identificador único del usuario cuyo historial de archivos se
	 *               desea obtener.
	 * @return `ResponseEntity<List<String>>` con el historial de archivos en
	 *         formato de lista de hashes SHA-256, y un código de respuesta HTTP 200
	 *         (OK) si la operación se realiza con éxito.
	 */
	@GetMapping("/{userId}/historial")
	public ResponseEntity<List<String>> obtenerHistorial(@PathVariable int userId) {
		List<String> historial = usuarioServ.obtenerHistorial(userId);
		return ResponseEntity.ok(historial);
	}

}
