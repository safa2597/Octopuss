package tn.esprit.spring.services;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.CertificatRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class CertificatService implements ICertificatService{
	@Autowired 
	CertificatRepository cr;
	@Autowired
	UserRepository ur;

	@Override
	@Transactional
	public Certificat addCertificat(Certificat c, Long id) {
		User user=ur.findById(id).get();
		c.setUser(user);
		return cr.save(c);

	}	
	

	@Override
	public Certificat updateCertificat(Certificat c) {
		return cr.save(c);
	}

	@Override
	public List<Certificat> findCertificats() {
		return (List<Certificat>)cr.findAll();
	}

	@Override
	public void deleteCertificat(Long idCertif) {
		cr.deleteById(idCertif);
		
	}

	@Override
	public void deleteCertificat(Certificat c) {
		cr.delete(c);
		
	}

	@Override
	public void affecterCertificattoUser(Long idUser, Long idCertif) {
		User user = ur.findById(idUser).orElse(null);
		System.out.print(user);
		Certificat certificat = cr.findById(idCertif).orElse(null);
		certificat.setUser(user);
		cr.save(certificat);
		
	}

	@Override
	public Certificat findCertificat(Long idCertificat) {
		return cr.findById(idCertificat).get();
	}

}
