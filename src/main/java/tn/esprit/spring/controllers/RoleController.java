package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.RoleServiceImpl;
import tn.esprit.spring.services.UserServiceImpl;

@RestController
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleServiceImpl roleserv;

	// http://localhost:8089/wecare/role/add-role
	@PostMapping("/add-role")
	public Role addRole(@RequestBody Role u) {
		return roleserv.addRole(u);
	}

	// http://localhost:8089/wecare/role/update-role
	@PutMapping("/update-role")
	public Role updateRole(@RequestBody Role u) {
		roleserv.updateRole(u);
		return u;
	}

	// http://localhost:8089/wecare/role/get-all-roles
	@GetMapping("/get-all-roles")
	public List<Role> getAll() {
		List<Role> listRole = roleserv.getAllRole();
		return listRole;
	}

	// http://localhost:8089/wecare/role/delete-role/2
	@DeleteMapping("/delete-role/{role-id}")
	public void deleteRole(@PathVariable("role-id") Long id) {
		roleserv.deleteRoleById(id);
	}

}
