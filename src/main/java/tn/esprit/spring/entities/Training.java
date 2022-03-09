package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Training implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTrain;
	private String title;
	private String domaine;
	private float price;
	private int nbParticipant;
	@JsonIgnore
	@ManyToMany(mappedBy="trainings",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<User> users;
	@JsonIgnore
	@OneToMany(mappedBy="training",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Quiz> quizs;
	@JsonIgnore
	@JsonManagedReference
	@OneToMany(mappedBy="training",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	private Set<Material> materials;
	@JsonIgnore
	@OneToMany(mappedBy="training",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<File> files;

}
