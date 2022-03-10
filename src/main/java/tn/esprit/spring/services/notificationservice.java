package tn.esprit.spring.services;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repositories.notificationRepository;

@Service
public class notificationservice implements inotificationservice {
	
	@Autowired
	notificationRepository notificationRepository;
	
	@Override
	public List<Event>  getEventsToday() {


	return  (List<Event>) notificationRepository.getEventsToday();
	}
	

	@Override
	public List<Event> getUpcomingEvents() {
	return notificationRepository.getUpcomingEvents(new Date());
	}

}
