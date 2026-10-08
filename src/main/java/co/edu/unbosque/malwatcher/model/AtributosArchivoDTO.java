package co.edu.unbosque.malwatcher.model;

import java.util.ArrayList;

/**
 * Data Transfer Object(DTO)que representa los atributos de un
 * archivo*analizado.*
 * <p>
 * *La clase`AtributosArchivoDTO`encapsula la información técnica y
 * de*identificación de un archivo,tales como sus hash,tipo de
 * archivo,tamaño,*etiquetas de tipo y otros atributos útiles para caracterizar
 * el archivo*analizado.*
 * </p>
 * *
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class AtributosArchivoDTO {

	/**
	 * Hash MD5 del archivo.
	 */
	private String md5 = "";

	/**
	 * Hash SHA-1 del archivo.
	 */
	private String sha1 = "";

	/**
	 * Hash ssdeep (fuzzy hash) del archivo.
	 */
	private String ssdeep = "";

	/**
	 * Hash TLSH (Trend Micro Locality Sensitive Hash) del archivo.
	 */
	private String tlsh = "";

	/**
	 * Tipo de archivo según su contenido.
	 */
	private String fileType = "";

	/**
	 * Información mágica del archivo (una cadena que describe el tipo de archivo).
	 */
	private String magika = "";

	/**
	 * Lista de etiquetas de tipo del archivo.
	 */
	private ArrayList<String> typeTags = new ArrayList<>();

	/**
	 * Tamaño del archivo en bytes.
	 */
	private String size = "";

	/**
	 * Información de tipo mágico del archivo.
	 */
	private String magic = "";

	/**
	 * Fecha de la primera vez que el archivo fue enviado para análisis.
	 */
	private String firstSubmissionDate = "";

	/**
	 * Nombre significativo del archivo (posiblemente renombrado o extraído de
	 * metadatos).
	 */
	private String meaningfulName = "";

	// Getters y setters
	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public String getSsdeep() {
		return ssdeep;
	}

	public void setSsdeep(String ssdeep) {
		this.ssdeep = ssdeep;
	}

	public String getTlsh() {
		return tlsh;
	}

	public void setTlsh(String tlsh) {
		this.tlsh = tlsh;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getMagika() {
		return magika;
	}

	public void setMagika(String magika) {
		this.magika = magika;
	}

	public ArrayList<String> getTypeTags() {
		return typeTags;
	}

	public void setTypeTags(ArrayList<String> typeTags) {
		this.typeTags = typeTags;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMagic() {
		return magic;
	}

	public void setMagic(String magic) {
		this.magic = magic;
	}

	public String getFirstSubmissionDate() {
		return firstSubmissionDate;
	}

	public void setFirstSubmissionDate(String firstSubmissionDate) {
		this.firstSubmissionDate = firstSubmissionDate;
	}

	public String getMeaningfulName() {
		return meaningfulName;
	}

	public void setMeaningfulName(String meaningfulName) {
		this.meaningfulName = meaningfulName;
	}

}
