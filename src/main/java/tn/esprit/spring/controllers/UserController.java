package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserServiceImpl userServ;

	// http://localhost:8089/pi/user/add-user   
	
	@PostMapping("/add-user") 
		public String addUser(@RequestBody User u)
		 {
			
			String msg="";
			User userExists = userServ.findUserByUserName(u.getUserName());
			
			msg="heyyyyy";
		
				userServ.sendSimpleEmail(u.getEmail(), "Your Username : "+u.getUserName()+" Your Password :"+u.getPassword(),
						"Welcome To WeCare");
			userServ.addUser(u);
			msg="Utilisateur ajouté avec succés et envoi de mail avec le password";
			

			return msg;
		}

	// http://localhost:8089/pi/user/update-user
	@PutMapping("/update-user")
	public User updateUser(@RequestBody User u) {

		userServ.updateUser(u);
		return u;
	}

	// http://localhost:8089/pi/user/get-all-users
	@GetMapping("/get-all-users")
	public List<User> getAll() {
		List<User> listUser = userServ.getAllUser();
		return listUser;
	}
	
	@GetMapping("/get-all-users-Undeleted")
	public List<User> getAllUndeleted() {
		List<User> listUser = userServ.getUndeletedUser();
		return listUser;
	}
	
	@GetMapping("/get-all-users-deleted")
	public List<User> getAlldeleted() {
		List<User> listUser = userServ.getdeletedUser();
		return listUser;
	}
	  

	// http://localhost:8089/pi/user/get-user-by-id/2
	@GetMapping("/get-user-by-id/{user-id}")
	public User getUserById(@PathVariable("user-id") Long id) {
		User u = userServ.getUserById(id);
		
		return u;
	}

	// http://localhost:8089/pi/user/locked-user/2
	@PutMapping("/locked-user/{user-id}")
	public void lockedUser(@PathVariable("user-id") Long id) {
		userServ.lockedUser(id);
	}

	
	
}
