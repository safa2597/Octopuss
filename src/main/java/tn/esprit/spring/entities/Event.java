package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
public class Event implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idEvent;
	private String evName;
	private String place;
	private Date dateEv;
	private String description;
	private int nbPlaces;
	private int nbParticipation;
	@ManyToMany(mappedBy="events",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<User> users;
}
