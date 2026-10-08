package co.edu.unbosque.malwatcher;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * Clase ServletInitializer para la aplicación Malwatcher.
 * <p>
 * Esta clase configura el despliegue de la aplicación en un servidor de
 * aplicaciones como un archivo WAR (Web Application Archive). Extiende
 * {@link SpringBootServletInitializer} y permite la inicialización de la
 * aplicación dentro de un contenedor de servlets compatible con Servlet 3.0 o
 * superior.
 * </p>
 *  @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class ServletInitializer extends SpringBootServletInitializer {
	/**
	 * Configura la aplicación para ejecutarse en un contenedor de servlets.
	 * <p>
	 * Sobrescribe el método {@code configure} de
	 * {@link SpringBootServletInitializer} para especificar la clase principal de
	 * la aplicación ({@link MalwatcherApplication}) y permitir el arranque de la
	 * aplicación en un entorno de despliegue de servidor.
	 * </p>
	 *
	 * @param application una instancia de {@link SpringApplicationBuilder} para
	 *                    configurar y personalizar la aplicación.
	 * @return el builder de la aplicación configurado con la clase principal.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MalwatcherApplication.class);
	}

}
