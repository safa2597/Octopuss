package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.QRCodeGenerator;
import tn.esprit.spring.services.ICertificatService;

@RestController
public class CertificatController {
	@Autowired
	ICertificatService cs;
	
	@PostMapping("/add-Certificat")
	public Certificat addCertificat(@RequestBody Certificat c) {
	Certificat Certificat = cs.addCertificat(c);
	return Certificat;
	}
	@DeleteMapping("/remove-Certificat/{Certificat-id}")
	public void removeCertificat(@PathVariable("Certificat-id") Long idCertif) {
	cs.deleteCertificat(idCertif);
	}
	@PutMapping("/modify-Certificat")
	public Certificat modifyCertificat(@RequestBody Certificat Certificat) {
	return cs.updateCertificat(Certificat);
	}
	@GetMapping("/retrieve-all-Certificats")
	public List<Certificat> getCertificats() {
	List<Certificat> listCertificats = cs.findCertificats();
	return listCertificats;
	}
	@PutMapping("/affectUserCertificat/{id-user}/{id-certificat}")
	public void affecterUserCertificat(@PathVariable("id-user") Long idUser,@PathVariable("id-certificat") Long idCertif){
		cs.affecterCertificattoUser(idUser, idCertif);
	}
private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

	
    @GetMapping(value = "/genrateAndDownloadQRCode/{codeText}/{width}/{height}")
		public void download(
				@PathVariable("codeText") String codeText,
				@PathVariable("width") Integer width,
				@PathVariable("height") Integer height)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/genrateQRCode/{codeText}/{width}/{height}")
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("codeText") String codeText,
   			@PathVariable("width") Integer width,
   			@PathVariable("height") Integer height)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(codeText, width, height));
   		    }
}
