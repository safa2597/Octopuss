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

import tn.esprit.spring.entities.Response;
import tn.esprit.spring.services.IResponseService;

@RestController
public class ResponseController {
	
	@Autowired
	IResponseService rp;

	@PostMapping("/add-Response")
	public Response addResponse(@RequestBody Response qz) {
	Response Response = rp.addResponse(qz);
	return Response;
	}
	
	@DeleteMapping("/remove-Response/{Response-id}")
	public void removeResponse(@PathVariable("Response-id") Long idQ) {
	rp.deleteResponse(idQ);
	}
	
	@PutMapping("/modify-Response")
	public Response modifyResponse(@RequestBody Response qz) {
	return rp.updateResponse(qz);
	}
	
	@GetMapping("/retrieve-all-Responses")
	public List<Response> getResponses() {
	List<Response> listResponses = rp.findResponses();
	return listResponses;
	}
	@PutMapping("/affect-response-quiz/{idR}/{idQuiz}")
	public void AffecterResponseToQuiz(@PathVariable("idR") Long idR,@PathVariable("idQuiz") Long idQuiz){
		rp.affecterResponseaQuiz(idR, idQuiz);
	}

}
