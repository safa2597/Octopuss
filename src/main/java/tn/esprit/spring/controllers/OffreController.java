package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.services.IOffreService;

@RequestMapping("/Offre")
@RestController
public class OffreController  {
	@Autowired
	IOffreService ios;
	@PostMapping("addOffre")
	@ResponseBody
	public void addOffre(@RequestBody Offre offre){
		ios.addOffre(offre);
		
	}
	
	
	@DeleteMapping("/supp-offre/{idOffre}")
	@ResponseBody

	public void suppOffre(@PathVariable Long idOffre)
	{
	ios.deleteOffre(idOffre);

	}
	
	@GetMapping("/getOffre")
	@ResponseBody
	public List<Offre> getListOffre() {
	return ios.getAllVisiteurs();
	}
	
	@PutMapping("/editOffre")
	public void editOffre(@RequestBody Offre offre){
		ios.editOffre(offre);
	}
	/*@GetMapping("/get-statistiqueOffreAll")
	@ResponseBody
	void nbrPosParOffreAll(){
	HashMap<Integer, Integer> nbrPosParOffreAll(){
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		List<Offre> offres = OffreService.retrieveAllOffres();
		offres.forEach(o->{
			System.out.println(o.getidOffre()+" : ");
			System.out.println(postulationRepository.nbrePosParOffre(o.getidOffre())+"/n");
			map1.put(o.getidOffre()  , postulationRepository.nbrePosParOffre(o.getidOffre()));
		});
		return map1;
	}

}*/
	}