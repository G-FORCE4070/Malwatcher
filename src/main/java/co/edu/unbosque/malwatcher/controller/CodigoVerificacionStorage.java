package co.edu.unbosque.malwatcher.controller;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Clase CodigoVerificacionStorage para el almacenamiento temporal de códigos de
 * verificación.
 * <p>
 * Esta clase utiliza un {@link ConcurrentHashMap} para almacenar códigos de
 * verificación asociados a direcciones de correo electrónico, proporcionando
 * una estructura de almacenamiento en memoria para la verificación de usuarios.
 * </p>
 *
 * <p>
 * Las operaciones disponibles incluyen almacenar un código, obtener un código y
 * eliminar un código en función del correo electrónico.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class CodigoVerificacionStorage {
	private static final ConcurrentHashMap<String, String> storage = new ConcurrentHashMap<>();

	/**
	 * Almacena un código de verificación asociado a una dirección de correo.
	 *
	 * @param correo la dirección de correo electrónico del usuario.
	 * @param codigo el código de verificación asociado al usuario.
	 */
	public static void almacenarCodigo(String correo, String codigo) {
		storage.put(correo, codigo);
	}

	/**
	 * Obtiene el código de verificación asociado a una dirección de correo.
	 *
	 * @param correo la dirección de correo electrónico del usuario.
	 * @return el código de verificación asociado a la dirección de correo, o
	 *         {@code null} si no existe.
	 */
	public static String obtenerCodigo(String correo) {
		return storage.get(correo);
	}

	/**
	 * Elimina el código de verificación asociado a una dirección de correo.
	 *
	 * @param correo la dirección de correo electrónico del usuario.
	 */
	public static void eliminarCodigo(String correo) {
		storage.remove(correo);
	}
}
