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
@ToString
public class Subscription implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSub;
	private String badge;
	private Date subDate;
	@OneToMany(mappedBy="subscription",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<User> users;

}
