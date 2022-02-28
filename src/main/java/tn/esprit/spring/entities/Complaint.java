package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Complaint implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idC;
	private String object;
	private String textC;
	private Date sendDate;
	@Enumerated(EnumType.STRING)
	private StatReclamation status;
	@ManyToOne
	private User user;
	@OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<RecResponse> recResponses;
}
