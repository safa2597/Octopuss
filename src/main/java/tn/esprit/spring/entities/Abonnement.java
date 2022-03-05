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
import javax.persistence.OneToMany;

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
public class Abonnement implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	public Long id;
	public String offre;
	private float frais;
	
	//@OneToMany(mappedBy="Abonnements",cascade = CascadeType.ALL)
	//private Set<User> users;
	
}
