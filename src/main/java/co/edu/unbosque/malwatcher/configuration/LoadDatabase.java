package co.edu.unbosque.malwatcher.configuration;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.unbosque.malwatcher.model.Usuario;
import co.edu.unbosque.malwatcher.repository.UsuarioRepository;
import co.edu.unbosque.malwatcher.util.AESUtil;

/**
 * Clase de configuración LoadDatabase para inicializar la base de datos de la
 * aplicación.
 * <p>
 * Esta clase verifica si existe un usuario administrador al arrancar la
 * aplicación. Si no existe, crea uno con credenciales encriptadas. Utiliza
 * {@link CommandLineRunner} para ejecutar esta inicialización en el arranque de
 * la aplicación.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@Configuration
public class LoadDatabase {
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	/**
	 * Método initDatabase que crea un usuario administrador al iniciar la
	 * aplicación.
	 * <p>
	 * Este método define un {@link CommandLineRunner} que verifica si existe un
	 * usuario con nombre de usuario "admin" en la base de datos. Si no existe, se
	 * crea un usuario administrador con credenciales encriptadas utilizando
	 * {@link AESUtil}.
	 * </p>
	 *
	 * @param userRepo el repositorio de usuarios {@link UsuarioRepository}
	 *                 utilizado para acceder y gestionar los datos de los usuarios.
	 * @return un {@link CommandLineRunner} que ejecuta la lógica de creación del
	 *         usuario administrador al iniciar la aplicación.
	 */
	@Bean
	CommandLineRunner initDatabase(UsuarioRepository userRepo) {

		return args -> {
			Optional<Usuario> found = userRepo.findByNombreUsuario(AESUtil.encrypt("admin"));
			if (found.isPresent()) {
				log.info("Admin already exists,  skipping admin creating  ...");
			} else {
				userRepo.save(new Usuario(0, AESUtil.encrypt("admin"), "", AESUtil.encrypt("1234567890"), "",
						new ArrayList<>()));
				log.info("Preloading admin user");
			}
		};
	}

}
