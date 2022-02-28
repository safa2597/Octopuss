package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Material;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repositories.MaterialRepository;
import tn.esprit.spring.repositories.TrainingRepository;

@Service
public class MaterialService implements IMaterialService{

	@Autowired MaterialRepository mr;
	@Autowired TrainingRepository tr;
	
	@Override
	public Material addMaterial(Material m) {

		return mr.save(m);
	}

	@Override
	public Material updateMaterial(Material m) {
		
		return mr.save(m);
	}

	@Override
	public List<Material> findMaterials() {
		
		return (List<Material>)mr.findAll();
	}

	@Override
	public void deleteMaterial(Long idMaterial) {
		mr.deleteById(idMaterial);
		
	}

	@Override
	public void deleteMaterial(Material m) {
		mr.delete(m);
		
	}
	@Override
	public void affecterMaterialaFormation(Long idTraining, Long idMaterial) {
		Training train = tr.findById(idTraining).orElse(null);
		Material material = mr.findById(idMaterial).orElse(null);
		material.setTraining(train);
		mr.save(material);
	}

}
