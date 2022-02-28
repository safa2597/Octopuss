package tn.esprit.spring.entities;



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
public class Moneypot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idJack;
	private float moneyCollected;
	private String rib;
	private float moneySpend;
	@ManyToMany(mappedBy="moneypots",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<User> users;

}
