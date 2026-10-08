/**
 * Paquete `co.edu.unbosque.malwatcher.util` para utilidades y funciones
 * auxiliares de la aplicación MalWatcher.
 * <p>
 * Este paquete contiene clases de utilidad que proporcionan funcionalidades
 * comunes, como encriptación, envío de correos electrónicos y otras
 * herramientas que son utilizadas por diferentes partes de la aplicación.
 * </p>
 *
 * Clases incluidas en este paquete:
 * 
 * - {@link AESUtil}: Clase de utilidad para realizar operaciones de
 * encriptación y desencriptación utilizando el algoritmo AES. Es utilizada para
 * proteger datos sensibles, como contraseñas y otras informaciones
 * confidenciales.
 * 
 * - {@link MailSender}: Clase que gestiona el envío de correos electrónicos en
 * la aplicación. Proporciona métodos para enviar correos de bienvenida y de
 * verificación con contenido HTML.
 * 
 * - {@link RemitenteCorreo}: Clase alternativa para el envío de correos
 * electrónicos. Similar a `MailSender`, permite personalizar el asunto y
 * contenido de los correos.
 * 
 * - `package-info.java`: Archivo de información del paquete, utilizado para
 * documentar el propósito general del paquete y la funcionalidad de las clases
 * utilitarias incluidas.
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
package co.edu.unbosque.malwatcher.util;