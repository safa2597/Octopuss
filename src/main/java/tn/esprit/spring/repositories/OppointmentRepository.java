package tn.esprit.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Expert;
import tn.esprit.spring.entities.Oppointment;

public interface OppointmentRepository extends JpaRepository<Oppointment, Long>{

	List<Oppointment> findByExpert(Expert expert);

}
