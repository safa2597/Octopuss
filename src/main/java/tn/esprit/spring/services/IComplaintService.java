package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.Complaint;

public interface IComplaintService {


	void addComplaint(Complaint c);
	public void deleteComplaint(Long idC);
	List<Complaint> findComplaints();
	public Complaint updateComplaint(Complaint c);
	public void affecterComplainttoUser(Long idUser, Long idC);

}
