package co.edu.unbosque.malwatcher.model;

/**
 * Data Transfer Object (DTO) para representar las características de un
 * análisis antivirus.
 * <p>
 * La clase `AnalisisCaracteristicasDTO` almacena información detallada sobre el
 * motor de análisis y el resultado obtenido, incluyendo el nombre del motor,
 * versión, actualización, categoría y resultado.
 * </p>
 *
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class AnalisisCaracteristicasDTO {
	/**
	 * Nombre del motor antivirus que realizó el análisis.
	 */
	private String engineName;
	/**
	 * Versión del motor antivirus utilizado en el análisis.
	 */
	private String engineVersion;
	/**
	 * Fecha de la última actualización del motor antivirus.
	 */
	private String engineUpdate;
	/**
	 * Categoría del análisis realizado (por ejemplo, malware, adware).
	 */
	private String category;
	/**
	 * Resultado del análisis (por ejemplo, limpio, infectado).
	 */
	private String result;

	// Getters y setters
	public String getEngineName() {
		return engineName;
	}

	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}

	public String getEngineUpdate() {
		return engineUpdate;
	}

	public void setEngineUpdate(String engineUpdate) {
		this.engineUpdate = engineUpdate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}