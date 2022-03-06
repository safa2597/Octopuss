package tn.esprit.spring.entities;



import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;





import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor

@ToString
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	private String email;
	private String firstName;
	private String lastName;
	private int nbPoints;
	private String password;
	private String userName;
	private Date birthDate;
	private boolean active;
	private boolean locked;
	private boolean enabled;
	private int deleted;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private Timestamp deletedAt;
	private String image;
	private int warningNum;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	private Set<Role> roles;


	public User(Long userId, String email, String firstName, String lastName, int nbPoints, String password,
			String userName, Date birthDate, boolean active, boolean locked, boolean enabled, int deleted,
			String image, int warningNum, Set<Role> roles) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nbPoints = nbPoints;
		this.password = password;
		this.userName = userName;
		this.birthDate = birthDate;
		this.active = active;
		this.locked = locked;
		this.enabled = enabled;
		this.deleted = deleted;
		this.image = image;
		this.warningNum = warningNum;
		this.roles = roles;
	}
	
	
	
	
	
}


