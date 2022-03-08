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
import tn.esprit.spring.services.QRCodeGenerator;
import tn.esprit.spring.services.ICertificatService;

@RestController
public class CertificatController {
	@Autowired
	ICertificatService cs;
	
	@PostMapping("/add-Certificat/{user-id}")
	public Certificat addCertificat(@RequestBody Certificat c,@PathVariable("user-id") Long id) throws Exception {
	Certificat certificat = cs.addCertificat(c,id);
	download(cs.findCertificat(certificat.getIdCertif()).getIdCertif());
	certificat.setQRCertif(QR_CODE_IMAGE_PATH);
	return cs.updateCertificat(certificat);
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

	
    @GetMapping(value = "/genrateAndDownloadQRCode/{Certificat-id}")
		public void download(
				@PathVariable("Certificat-id") Long idCertif)
			    throws Exception {
			        QRCodeGenerator.generateQRCodeImage(cs.findCertificat(idCertif).toString(), QR_CODE_IMAGE_PATH);
			    }

    @GetMapping(value = "/genrateQRCode/{Certificat-id}")
   	public ResponseEntity<byte[]> generateQRCode(
   			@PathVariable("Certificat-id") Long idCertif)
   		    throws Exception {
   		        return ResponseEntity.status(HttpStatus.OK).body(QRCodeGenerator.getQRCodeImage(cs.findCertificat(idCertif).toString()));
   		    }
}
