package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.iservices.IRoleService;
import tn.esprit.spring.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	RoleRepository rolerepository;
	@Override
	public Role addRole(Role u) {
		return rolerepository.save(u);
	}

	@Override
	public Role updateRole(Role u) {
		return this.rolerepository.save(u);
	}

	@Override
	public List<Role> getAllRole() {
		return rolerepository.findAll();
	}

	@Override
	public void deleteRoleById(Long id) {
		rolerepository.deleteById(id);
		
	}

}
