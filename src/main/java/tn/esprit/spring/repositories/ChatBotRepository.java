package tn.esprit.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.ChatBotRate;

public interface ChatBotRepository extends JpaRepository<ChatBotRate, Long> {

}
