package tn.esprit.spring.services;

import java.util.List;

import org.springframework.mail.javamail.JavaMailSender;

import tn.esprit.spring.entities.Event;


public interface IEventService {
	public Event addEvent(Event e);
	public Event updateEvent(Event e);
	public List<Event> findEvents();
	public void deleteEvent (Long idEvent);
	public void deleteEvent(Event e);
	

	public void ajouterEventEtAffecterAuser(long idEvent , long id );
	public void MailService(JavaMailSender javaMailSender);
}
