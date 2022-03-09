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


import tn.esprit.spring.entities.Profile;

import tn.esprit.spring.services.IProfileServices;




@RequestMapping("/Profile")
@RestController
public class ProfileController {
	@Autowired
	IProfileServices ips;
	@PostMapping("addProfile")
	@ResponseBody
	public void addProfile(@RequestBody Profile profile){
		ips.addProfile(profile);

	
	}
	
	@DeleteMapping("/supp-profile/{idProfile}")
	@ResponseBody
     public void suppOffre(@PathVariable Long idProfile)
	{
	ips.deleteProfile(idProfile);

	}
	

	@GetMapping("/getProfile")
	@ResponseBody
	public List<Profile> getProfiles() {
		return ips.getProfiles();
	}
	@PutMapping("/editProfile")
	public void editProfile(@RequestBody Profile profile){
		ips.editProfiles(profile);
	}
	
	
	
	@GetMapping("/getPourcentage")
	public float getPoucentage(){
		return ips.pourcentageProfil();
	}
	

}
