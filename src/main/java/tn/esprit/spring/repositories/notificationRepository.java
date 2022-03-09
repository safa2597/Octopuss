package tn.esprit.spring.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Notification;

@Repository
	public interface notificationRepository extends CrudRepository<Notification,Long> {
	
	@Query("select e from Event e where e.dateEv >= ?1")
	public List<Event> getUpcomingEvents(Date d);
	@Query("select e from Event e where e.dateEv = CURRENT_DATE")
	public List<Event> getEventsToday();
	}


