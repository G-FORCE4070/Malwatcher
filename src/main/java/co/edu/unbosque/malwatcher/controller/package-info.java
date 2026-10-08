/**
 * Paquete `co.edu.unbosque.malwatcher.controller` para manejar las solicitudes
 * HTTP de la aplicación MalWatcher.
 * <p>
 * Este paquete contiene las clases controladoras que gestionan las solicitudes
 * de los usuarios, las cuales permiten realizar operaciones relacionadas con
 * los usuarios y el análisis de archivos a través de la integración con la API
 * de VirusTotal.
 * </p>
 *
 * Clases incluidas en este paquete:
 * 
 * - {@link CodigoVerificacionStorage}: Clase para almacenar y gestionar
 * temporalmente los códigos de verificación asociados a los correos
 * electrónicos de los usuarios. Utiliza una estructura de almacenamiento
 * concurrente para manejar múltiples solicitudes de verificación.
 * 
 * - {@link UsuarioController}: Controlador que gestiona las solicitudes
 * relacionadas con los usuarios. Proporciona endpoints para crear cuentas,
 * verificar usuarios, iniciar sesión y realizar operaciones CRUD en la base de
 * datos de usuarios.
 * 
 * - {@link VirusTotalController}: Controlador que gestiona las solicitudes
 * relacionadas con la API de VirusTotal. Permite subir archivos para análisis y
 * obtener reportes detallados de los mismos.
 * 
 * - `package-info.java`: Archivo de información del paquete, utilizado para
 * documentar y describir el propósito general del paquete y su funcionalidad en
 * la aplicación.
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 * 
 */
package co.edu.unbosque.malwatcher.controller;