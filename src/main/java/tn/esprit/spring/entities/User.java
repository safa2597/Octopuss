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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstname;
	private String lastname;
	private Date birthDate;
	private String email;
	private String address;
	private String telnumber;
	private String sex;
	private String userName;
	private String password;
	private Boolean active;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Role> roles;
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonIgnore
	private Set<Complaint> complaints;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Chat> chats;
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Subject> subjects;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Training> trainings;
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Certificat> certificats;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Event> events;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Moneypot> moneypots;
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Oppointment> oppointments;
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Availability> availabilities;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Pub> pubs;
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Offre> offres;
	@OneToOne
	private Profile profile;
	@ManyToOne
	private Subscription subscription;

}
