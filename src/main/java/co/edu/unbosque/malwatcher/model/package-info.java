/**
 * Paquete `co.edu.unbosque.malwatcher.model` para definir las entidades y
 * objetos de transferencia de datos (DTO) utilizados en la aplicación
 * MalWatcher.
 * <p>
 * Este paquete contiene clases que representan tanto las entidades persistentes
 * en la base de datos como los objetos de transferencia de datos (DTO) que
 * facilitan la comunicación entre el backend y el frontend.
 * </p>
 *
 * Clases incluidas en este paquete:
 * 
 * - {@link AnalisisCaracteristicasDTO}: DTO que representa las características
 * de un análisis antivirus, incluyendo detalles como el nombre del motor
 * antivirus, la versión y el resultado del análisis.
 * 
 * - {@link AnalisisVirusDTO}: DTO que almacena los resultados generales de un
 * análisis de archivo en VirusTotal, incluyendo estadísticas como archivos
 * detectados como maliciosos, sospechosos y los resultados específicos de cada
 * motor antivirus.
 * 
 * - {@link AtributosArchivoDTO}: DTO que contiene atributos detallados de un
 * archivo escaneado, tales como los hashes (md5, sha1, ssdeep), el tipo de
 * archivo, el tamaño, y otras características descriptivas.
 * 
 * - {@link Usuario}: Entidad que representa a los usuarios en la base de datos.
 * Contiene atributos como nombre de usuario, correo electrónico, contraseña y
 * código de verificación.
 * 
 * - `package-info.java`: Archivo de información del paquete, que proporciona
 * documentación general sobre el propósito de las clases incluidas en el
 * paquete.
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
package co.edu.unbosque.malwatcher.model;