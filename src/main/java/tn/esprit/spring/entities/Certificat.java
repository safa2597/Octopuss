package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class Certificat implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCertif;
	private String QRCertif;
	private String title;
	private Date dateCertif;
	private String cachet;
	@ManyToOne
	@JsonBackReference
	@JsonIgnore
	private User user;
	@Override
	public String toString() {
		return "Certificat " + title +"\n de " + user.getFirstname() +" "+user.getLastname()+ "\n creer le " + dateCertif;
	}
	

}
