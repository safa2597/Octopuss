package tn.esprit.spring.services;



import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.EventRepository;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class EventService implements IEventService {
	@Autowired
	EventRepository er;
	UserRepository ur;
	@Override
	public Event addEvent(Event e) {
		// TODO Auto-generated method stub
		return er.save(e);
	}

	@Override
	public Event updateEvent(Event e) {
		// TODO Auto-generated method stub
		return er.save(e);
	}

	@Override
	public List<Event> findEvents() {
		// TODO Auto-generated method stub
		return (List<Event>) er.findAll();
	}

	@Override
	public void deleteEvent(Long idEvent) {
		// TODO Auto-generated method stub
		er.deleteById(idEvent);
	}

	@Override
	public void deleteEvent(Event e) {
		// TODO Auto-generated method stub
		er.delete(e);
		
	}
	
	@Override
	public void ajouterEventEtAffecterAuser(long idEvent , long id ) {
		User u = ur.findById(id).get();
		Event e = er.findById(idEvent).get();
		u.getEvents().add(e);
			
	}
	
	private JavaMailSender javaMailSender;
	@Autowired
	//@Scheduled(cron = "0 0 0 */14 *" )
	
	public void MailService(JavaMailSender javaMailSender) {
		 DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	        String currentDate = dateFormatter.format(new Date());
	        List<Event> e=(List<Event>) er.findAll();
	        for(Event event:e)
	        {
	       if( currentDate.equals(event.getDateEv()))

	    	   this.javaMailSender = javaMailSender;
	        }
	}


	
	

}
