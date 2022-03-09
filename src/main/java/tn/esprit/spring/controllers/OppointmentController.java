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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Oppointment;
import tn.esprit.spring.services.IOppointmentService;

@RestController
@Api(tags = "Gestion des oppointment")
@RequestMapping("/Oppointment")

public class OppointmentController {
	@Autowired
	IOppointmentService ios;
	
	@PostMapping("addOppointment")
	@ResponseBody
	public void addOppointment(@RequestBody Oppointment o) {
	ios.addOppointment(o);
	}
	
	@DeleteMapping("/delete-Oppointment/{idOp}")
	@ResponseBody
	public void deleteOppointment(@PathVariable("idOp") Long idOp){
		System.out.println(idOp);
		ios.deleteOppointment(idOp);}
	
	@GetMapping("/retrieve-all-Oppointment")
	@ResponseBody
	public List<Oppointment> getOppointments() {
	return ios.findOppointments();
	}
	
	@PutMapping("/modify-Oppointment")
	public Oppointment modifyOppointment(@RequestBody Oppointment Oppointment) {
	return ios.updateOppointment(Oppointment);
	}

}
