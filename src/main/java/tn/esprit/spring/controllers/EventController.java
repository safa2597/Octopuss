package tn.esprit.spring.controllers;

import java.util.List;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEventService;
import tn.esprit.spring.services.MailService;


@RestController
public class EventController {

	IEventService es;

	@PostMapping("ajouterEvent")
	public Event ajouterEvent(@RequestBody Event mp) {
		return es.addEvent(mp);
	}
	@PutMapping("modifierEvent")
	public Event modifierEvent(@RequestBody Event mp) {
		return es.updateEvent(mp);
	}
	@DeleteMapping("supprimerEvent")
	public void supprimerEvent(@PathVariable("idEvent") Long idEvent) {
		es.deleteEvent(idEvent);
		
	}
	@GetMapping("listerEvent")
	public List<Event> getEvents() {
	List<Event> listEvents = es.findEvents();
		return listEvents;
	}
	
	

@PutMapping("/affectUserEvent/{id-user}/{id-event}")
	public void affecterUserEvent(@PathVariable("id-user") Long idUser,@PathVariable("id-event") Long idEvent){
		es.ajouterEventEtAffecterAuser(idEvent, idUser);
	}
@Autowired
private MailService notificationService;


@Autowired
private User user;

/**
 * 
 * @return
 */
//@RequestMapping("send-mail")
//@Scheduled(cron = "0 0 0 */14 *" )
@Scheduled(cron = "0 0 */1 * * *" )
public String send() {

	/*
	 * Creating a User with the help of User class that we have declared and setting
	 * Email address of the sender.
	 */
	user.setEmail("safa.khouja@esprit.tn");  //Receiver's email address
	/*
	 * Here we will call sendEmail() for Sending mail to the sender.
	 */
	try {
		notificationService.sendEmail(user);
	} catch (MailException mailException) {
		System.out.println(mailException);
	}
	return "Congratulations! Your mail has been send to "+user;
}

/**
 * 
 * @return
 * @throws MessagingException
 */
@RequestMapping("send-mail-attachment")
public String sendWithAttachment() throws MessagingException {

	/*
	 * Creating a User with the help of User class that we have declared and setting
	 * Email address of the sender.
	 */
	user.setEmail("sejir.bali@esprit.tn"); //Receiver's email address

	/*
	 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
	 * that contains a attachment.
	 */
	try {
		notificationService.sendEmailWithAttachment(user);
	} catch (MailException mailException) {
		System.out.println(mailException);
	}
	return "Congratulations! Your mail has been send to the user.";
}


}







