package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Profile;

public interface IProfileServices {
void addProfile(Profile profile);
public void deleteProfile(Long idProfile);
List<Profile> getProfiles();
void editProfiles(Profile profile);
float pourcentageProfil();
public List<Offre> recomandation(Long idProfile);
}
