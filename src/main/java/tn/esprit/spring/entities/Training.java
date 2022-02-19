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
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Training implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idTrain;
	private String title;
	private String domaine;
	private float price;
	@ManyToMany(mappedBy="trainings",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<User> users;
	@OneToMany(mappedBy="training",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Quiz> quizs;
	@OneToMany(mappedBy="training",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Material> materials;

}
