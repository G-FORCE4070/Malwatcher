/**
 * Paquete `co.edu.unbosque.malwatcher.service` para la lógica de negocio de la
 * aplicación MalWatcher.
 * <p>
 * Este paquete contiene las clases de servicio que implementan la lógica de
 * negocio de la aplicación, incluyendo la gestión de usuarios y la interacción
 * con la API externa de VirusTotal para el análisis de archivos.
 * </p>
 *
 * Clases incluidas en este paquete:
 * 
 * - {@link HttpHandler}: Clase que maneja la comunicación HTTP directa con la
 * API de VirusTotal. Proporciona métodos para enviar solicitudes HTTP y manejar
 * las respuestas de la API.
 * 
 * - {@link UsuarioService}: Servicio que gestiona las operaciones relacionadas
 * con los usuarios. Proporciona métodos para crear, actualizar, y validar
 * usuarios, además de realizar consultas personalizadas.
 * 
 * - {@link VirusTotalService}: Servicio que interactúa con la API de
 * VirusTotal. Permite realizar análisis de archivos, obtener reportes de
 * análisis y manejar las operaciones relacionadas con el análisis de archivos
 * subidos.
 * 
 * - `package-info.java`: Archivo de información del paquete, utilizado para
 * documentar el propósito y la funcionalidad de las clases de servicio
 * incluidas en este paquete.
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
package co.edu.unbosque.malwatcher.service;