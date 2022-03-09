package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Profile;
import tn.esprit.spring.repositories.ProfileRepository;
import tn.esprit.spring.services.IProfileServices;
@Service
public class ProfileService implements IProfileServices{
	@Autowired
	ProfileRepository pr;

	@Override
	public void addProfile(Profile profile) {
		pr.save(profile);
		
	}

	@Override
	public void deleteProfile(Long idProfile) {
		pr.deleteById(idProfile);
		
	}

	@Override
	public List<Profile> getProfiles() {
		return (List<Profile>) pr.findAll();
	}

	@Override
	public void editProfiles(Profile profile) {
		pr.save(profile);
		
	}

	@Override
	public float pourcentageProfil() {
		
		float dom=pr.compterProfile().size();
		return ((List<Profile>) pr.findAll()).size() * 100/dom;
	}

	

}
