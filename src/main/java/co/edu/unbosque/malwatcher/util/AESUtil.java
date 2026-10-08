package co.edu.unbosque.malwatcher.util;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Utilidad para encriptación y desencriptación de texto utilizando el algoritmo
 * AES.
 * <p>
 * La clase `AESUtil` proporciona métodos para encriptar y desencriptar cadenas
 * de texto usando AES en modo CBC con PKCS5Padding.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
public class AESUtil {
	/**
	 * Nombre del algoritmo de cifrado (AES).
	 */
	private final static String ALGORITMO = "AES";
	/**
	 * Tipo de cifrado especificado: AES en modo CBC con PKCS5Padding.
	 */
	private final static String TIPOCIFRADO = "AES/CBC/PKCS5Padding";

	/**
	 * Encripta un texto utilizando una clave y un vector de inicialización (IV)
	 * específicos.
	 *
	 * @param llave la clave secreta de 16 caracteres utilizada para la
	 *              encriptación.
	 * @param iv    el vector de inicialización de 16 caracteres.
	 * @param texto el texto a encriptar.
	 * @return el texto encriptado en base64.
	 */
	public static String encrypt(String llave, String iv, String texto) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(TIPOCIFRADO);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}

		SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), ALGORITMO);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		try {
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
		}

		byte[] encrypted = null;
		try {
			encrypted = cipher.doFinal(texto.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		return new String(encodeBase64(encrypted));
	}

	/**
	 * Desencripta un texto encriptado en base64 utilizando una clave y un vector de
	 * inicialización (IV) específicos.
	 *
	 * @param llave     la clave secreta de 16 caracteres utilizada para la
	 *                  desencriptación.
	 * @param iv        el vector de inicialización de 16 caracteres.
	 * @param encrypted el texto encriptado en base64.
	 * @return el texto desencriptado en formato de texto plano.
	 */
	public static String decrypt(String llave, String iv, String encrypted) {
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance(TIPOCIFRADO);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}

		SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), ALGORITMO);
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {

			e.printStackTrace();
		}

		byte[] enc = decodeBase64(encrypted);
		byte[] decrypted = null;
		try {
			decrypted = cipher.doFinal(enc);
		} catch (IllegalBlockSizeException | BadPaddingException e) {

			e.printStackTrace();
		}

		return new String(decrypted);
	}

	/**
	 * Desencripta un texto encriptado usando una clave y un IV predefinidos.
	 *
	 * @param encrypted el texto encriptado en base64.
	 * @return el texto desencriptado en texto plano.
	 */
	public static String decrypt(String encrypted) {
		String iv = "programacioncomp";
		String key = "llavede16carater";
		return decrypt(key, iv, encrypted);
	}

	/**
	 * Encripta un texto usando una clave y un IV predefinidos.
	 *
	 * @param plainText el texto en formato plano que se desea encriptar.
	 * @return el texto encriptado en base64.
	 */
	public static String encrypt(String plainText) {
		String iv = "programacioncomp";
		String key = "llavede16carater";
		return encrypt(key, iv, plainText);
	}

}
