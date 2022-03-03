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

import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.services.IComplaintService;

@RestController
@Api(tags = "Gestion des complaint")
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	IComplaintService ics;
	
	@PostMapping("addComplaint")
	@ResponseBody
	public void addComplaint(@RequestBody Complaint c) {
	ics.addComplaint(c);
	}
	
	@DeleteMapping("/delete-Complain/{idC}")
	@ResponseBody
	public void deleteComplaint(@PathVariable Long idC){
		ics.deleteComplaint(idC);}
		
		@GetMapping("/retrieve-all-Complaints")
		@ResponseBody
		public List<Complaint> getComplaints() {
		return ics.findComplaints();
		}
		
		@PutMapping("/modify-Complaint")
		public Complaint modifyComplaint(@RequestBody Complaint Complaint) {
		return ics.updateComplaint(Complaint);
		}
		
		@PutMapping("/affectUserComplaint/{id-user}/{id-complaint}")
		public void affecterUserComplaint(@PathVariable("id-user") Long idUser,@PathVariable("id-complaint") Long idC){
			ics.affecterComplainttoUser(idUser, idC);
		}
	
	}