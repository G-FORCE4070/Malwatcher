package co.edu.unbosque.malwatcher.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data Transfer Object (DTO) que representa los resultados del análisis de un
 * archivo realizado por varios motores antivirus.
 * <p>
 * La clase `AnalisisVirusDTO` contiene información relevante sobre el estado y
 * los resultados del análisis, incluyendo detalles sobre detecciones, estatus
 * de análisis, tiempos de espera y resultados específicos de cada motor
 * antivirus utilizado.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */

public class AnalisisVirusDTO {
	/**
	 * Hash SHA-256 del archivo analizado.
	 */
	private String sha256;
	/**
	 * Indicador de detecciones maliciosas en el archivo.
	 */
	private String malicious;
	/**
	 * Indicador de detecciones sospechosas en el archivo.
	 */
	private String suspicious;
	/**
	 * Número de motores antivirus que no detectaron ninguna amenaza en el archivo.
	 */
	private int undetected;
	/**
	 * Indicador de que el archivo fue considerado inofensivo.
	 */
	private String harmless;
	/**
	 * Número de motores antivirus cuyo análisis excedió el tiempo límite.
	 */
	private int timeout;
	/**
	 * Número de motores que confirmaron un timeout en el análisis del archivo.
	 */
	private int confirmedTimeout;
	/**
	 * Número de motores que encontraron errores durante el análisis.
	 */
	private int failure;
	/**
	 * Número de motores que no pudieron analizar el archivo por incompatibilidad de
	 * tipo.
	 */
	private int typeUnsupported;
	/**
	 * Estado general del análisis (por ejemplo, "completado", "pendiente").
	 */
	private String status;

	/**
	 * Lista de resultados detallados del análisis de cada motor antivirus.
	 */
	private List<AnalisisCaracteristicasDTO> antivirusResults = new ArrayList<>();

	// Getters y setters
	public String getSha256() {
		return sha256;
	}

	public void setSha256(String sha256) {
		this.sha256 = sha256;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMalicious() {
		return malicious;
	}

	public void setMalicious(String malicious) {
		this.malicious = malicious;
	}

	public String getSuspicious() {
		return suspicious;
	}

	public void setSuspicious(String suspicious) {
		this.suspicious = suspicious;
	}

	public int getUndetected() {
		return undetected;
	}

	public void setUndetected(int undetected) {
		this.undetected = undetected;
	}

	public String getHarmless() {
		return harmless;
	}

	public void setHarmless(String harmless) {
		this.harmless = harmless;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getConfirmedTimeout() {
		return confirmedTimeout;
	}

	public void setConfirmedTimeout(int confirmedTimeout) {
		this.confirmedTimeout = confirmedTimeout;
	}

	public int getFailure() {
		return failure;
	}

	public void setFailure(int failure) {
		this.failure = failure;
	}

	public int getTypeUnsupported() {
		return typeUnsupported;
	}

	public void setTypeUnsupported(int typeUnsupported) {
		this.typeUnsupported = typeUnsupported;
	}

	public List<AnalisisCaracteristicasDTO> getAntivirusResults() {
		return antivirusResults;
	}

	public void setAntivirusResults(List<AnalisisCaracteristicasDTO> antivirusResults) {
		this.antivirusResults = antivirusResults;
	}

}
