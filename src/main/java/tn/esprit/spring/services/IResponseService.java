package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Response;

public interface IResponseService {

	public Response addResponse(Response Response);
	public Response updateResponse(Response Response);
	public List<Response> findResponses();
	public void deleteResponse(Long idR);
	void deleteResponse(Response Response);
	public void affecterResponseaQuiz(Long idR, Long idQuiz);
}
