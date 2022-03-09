package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Certificat;

public interface ICertificatService {

	public Certificat addCertificat(Certificat c, Long id);
	public Certificat updateCertificat(Certificat c);
	public List<Certificat> findCertificats();
	public void deleteCertificat(Long idCertif);
	void deleteCertificat(Certificat c);
	public void affecterCertificattoUser(Long id, Long idCertif);
	public Certificat findCertificat(Long idCertificat);

}
