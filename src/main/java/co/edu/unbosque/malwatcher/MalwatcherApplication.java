package co.edu.unbosque.malwatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Malwatcher.
 * <p>
 * Esta clase es el punto de entrada de la aplicación Spring Boot. Contiene el
 * método main que inicia el contenedor de Spring y lanza la aplicación.
 * </p>
 *
 * <p>
 * La anotación {@link SpringBootApplication} activa la configuración automática
 * de Spring, el escaneo de componentes y permite registrar beans en el contexto
 * de la aplicación.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@SpringBootApplication
public class MalwatcherApplication {
	/**
	 * Método principal que inicia la aplicación Malwatcher.
	 * <p>
	 * Este método invoca el método {@link SpringApplication#run(Class, String[])}
	 * para lanzar el contenedor de Spring y cargar todos los componentes definidos
	 * en el contexto de la aplicación.
	 * </p>
	 *
	 * @param args Argumentos de la línea de comandos (opcional).
	 */
	public static void main(String[] args) {
		SpringApplication.run(MalwatcherApplication.class, args);
	}

}
