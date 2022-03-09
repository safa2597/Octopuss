package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.services.inotificationservice;

@RestController
public class NotificationController {
	@Autowired
	inotificationservice inotificationservice;
	
	@Scheduled(fixedRate=60000)
	public void CheckEventsToday() {

		List<Event> lst = inotificationservice.getEventsToday();

		for (Event event : lst) {
		System.out.println("  description: " + event.getDescription() + "\n" );
		}
		}

	@GetMapping(value = "/getUpcomingEvents")
	@ResponseBody
	public List<Event> getUpcomingEvents() {
	return inotificationservice.getUpcomingEvents();
	}

}
