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
public class Add implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAdd;
	private String pubDesc;
	private Date startDate;
	private Date finishDate;
	private int nbInitView;
	private int nbAchiveView;
	private float cost;
	@ManyToMany(mappedBy="adds",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<User> users;
}
