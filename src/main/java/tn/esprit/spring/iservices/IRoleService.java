package tn.esprit.spring.iservices;

import java.util.List;

import tn.esprit.spring.entities.Role;

public interface IRoleService  {
	public Role addRole(Role u);
	public Role updateRole(Role u);
	public List<Role> getAllRole();
	public void deleteRoleById(Long id);

}
