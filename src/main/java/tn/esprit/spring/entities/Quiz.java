package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor; 
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Quiz implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idQuiz;
	private int score;
	@ManyToOne
	@JsonBackReference
	private Training training;
	@OneToMany(mappedBy="quiz",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonIgnore
	@JsonManagedReference
	private List<Question> questions;
	

}
