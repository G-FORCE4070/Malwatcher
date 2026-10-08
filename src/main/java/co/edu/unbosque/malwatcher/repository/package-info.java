/**
 * Paquete `co.edu.unbosque.malwatcher.repository` para la gestión de la
 * persistencia de datos de la aplicación MalWatcher.
 * <p>
 * Este paquete contiene las interfaces que extienden los repositorios de Spring
 * Data JPA, permitiendo realizar operaciones de CRUD (Crear, Leer, Actualizar,
 * Eliminar) y consultas adicionales en la base de datos para las entidades de
 * la aplicación.
 * </p>
 *
 * Clases incluidas en este paquete:
 * 
 * - {@link UsuarioRepository}: Repositorio que gestiona la persistencia de la
 * entidad {@link Usuario}. Proporciona métodos para buscar usuarios por nombre
 * de usuario, además de las operaciones CRUD estándar proporcionadas por Spring
 * Data JPA.
 * 
 * - `package-info.java`: Archivo de información del paquete, utilizado para
 * documentar el propósito y la funcionalidad de las clases incluidas en este
 * paquete.
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
package co.edu.unbosque.malwatcher.repository;