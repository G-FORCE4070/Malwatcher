package co.edu.unbosque.malwatcher.controller;

import co.edu.unbosque.malwatcher.model.AnalisisVirusDTO;
import co.edu.unbosque.malwatcher.model.AtributosArchivoDTO;
import co.edu.unbosque.malwatcher.service.VirusTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

/**
 * Controlador REST para la integración con la API de VirusTotal en la
 * aplicación Malwatcher.
 * <p>
 * Este controlador proporciona endpoints para escanear archivos y obtener
 * reportes de análisis de VirusTotal, utilizando el servicio
 * {@link VirusTotalService}.
 * </p>
 * 
 * @author Hospital Herrera Dylan Mathyus
 * @author Ruiz Cruz Gabriel Alejandro
 * @author Triana Mejia Juan Diego
 * @author Vela Cardozo German Octavio
 */
@RestController
@RequestMapping("/api/virustotal")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" })
public class VirusTotalController {

	@Autowired
	private final VirusTotalService virusTotalService;

	/**
	 * Constructor para inyectar el servicio VirusTotalService.
	 *
	 * @param virusTotalService servicio utilizado para interactuar con la API de
	 *                          VirusTotal.
	 */
	public VirusTotalController(VirusTotalService virusTotalService) {
		this.virusTotalService = virusTotalService;
	}

	/**
	 * Escanea un archivo utilizando la API de VirusTotal.
	 * <p>
	 * Este método recibe un archivo, lo transfiere al directorio temporal del
	 * sistema y lo envía al servicio VirusTotal para su análisis.
	 * </p>
	 *
	 * @param file el archivo a escanear, proporcionado como un archivo multipart.
	 * @return un objeto {@link AnalisisVirusDTO} con los resultados del análisis,
	 *         envuelto en un {@link ResponseEntity} con estado HTTP 200 OK.
	 * @throws IOException          si ocurre un error al transferir el archivo o en
	 *                              la comunicación con VirusTotal.
	 * @throws InterruptedException si el proceso de análisis es interrumpido.
	 */
	@PostMapping("/scan")
	public ResponseEntity<AnalisisVirusDTO> scanFile(@RequestParam("file") MultipartFile file)
			throws IOException, InterruptedException {
		File fileToUpload = new File(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
		file.transferTo(fileToUpload);

		AnalisisVirusDTO analysis = virusTotalService.scanFile(fileToUpload);
		return ResponseEntity.ok(analysis);
	}

	/**
	 * Escanea un archivo utilizando la API de VirusTotal.
	 * <p>
	 * Este método recibe un archivo, lo transfiere al directorio temporal del
	 * sistema y lo envía al servicio VirusTotal para su análisis.
	 * </p>
	 *
	 * @param file el archivo a escanear, proporcionado como un archivo multipart.
	 * @return un objeto {@link AnalisisVirusDTO} con los resultados del análisis,
	 *         envuelto en un {@link ResponseEntity} con estado HTTP 200 OK.
	 * @throws IOException          si ocurre un error al transferir el archivo o en
	 *                              la comunicación con VirusTotal.
	 * @throws InterruptedException si el proceso de análisis es interrumpido.
	 */
	@GetMapping("/report/{scanId}")
	public ResponseEntity<AtributosArchivoDTO> getReport(@PathVariable String scanId) throws IOException {
		// Obtiene el reporte completo en formato DTO
		AtributosArchivoDTO report = virusTotalService.getReport(scanId);
		return ResponseEntity.ok(report);
	}
}