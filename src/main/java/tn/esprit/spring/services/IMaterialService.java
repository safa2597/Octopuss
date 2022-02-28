package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Material;

public interface IMaterialService {
	public Material addMaterial(Material m);
	public Material updateMaterial(Material m);
	public List<Material> findMaterials();
	public void deleteMaterial(Long idMaterial);
	void deleteMaterial(Material m);
	void affecterMaterialaFormation(Long idTraining, Long idMaterial);

}
