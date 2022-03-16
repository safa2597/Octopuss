package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Profile;
import tn.esprit.spring.repositories.OfffreRepository;
import tn.esprit.spring.repositories.ProfileRepository;
import tn.esprit.spring.services.IProfileServices;
@Service
public class ProfileService implements IProfileServices{
	@Autowired
	ProfileRepository pr;

	@Autowired
	OfffreRepository or;
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

	/*public List<Offre> recomandation(Long idProfile){
		List<Offre> ofList=new ArrayList<Offre>();
		Profile p=pr.findById(idProfile).get();
		for(String c:p.getCentreInteret()){
			for (Offre o:or.findAll())
			{
			if(c.equals(o.getCentreInteret())){
				ofList.add(o);
			}
			}
		}
		return  ofList;
	}*/

}
