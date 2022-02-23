package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Material;
import tn.esprit.spring.services.IMaterialService;

@RestController
public class MaterialController {

	@Autowired
	IMaterialService ms;

	@PostMapping("/add-Material")
	public Material addMaterial(@RequestBody Material m) {
	Material Material = ms.addMaterial(m);
	return Material;
	}
	@DeleteMapping("/remove-Material/{Material-id}")
	public void removeMaterial(@PathVariable("Material-id") Long idMaterial) {
	ms.deleteMaterial(idMaterial);
	}
	@PutMapping("/modify-Material")
	public Material modifyMaterial(@RequestBody Material m) {
	return ms.updateMaterial(m);
	}
	@GetMapping("/retrieve-all-Materials")
	public List<Material> getMaterials() {
	List<Material> listMaterials = ms.findMaterials();
	return listMaterials;
	}
	@PutMapping("/add-training-material/{idTraining}/{idMaterial}")
	public void ajouterEtAffecterTrainingMaterial(@PathVariable("idTraining") Long idTraining,@PathVariable("idMaterial") Long idMaterial){
		ms.affecterMaterialaFormation(idTraining, idMaterial);
	}
}
