package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Event;

public interface inotificationservice  {

	public List<Event> getEventsToday();

	public List<Event> getUpcomingEvents();
}
