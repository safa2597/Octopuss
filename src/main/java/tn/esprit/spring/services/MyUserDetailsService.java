package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
    UserServiceImpl userService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findUserByUserName(userName);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return new org.springframework.security.core.userdetails.User(user.getUserName(),

				user.getPassword(), user.isActive(), true, true, true, authorities);
	}

	private List<GrantedAuthority> getUserAuthority(Set<Role> userRoles) {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			roles.add(new SimpleGrantedAuthority(role.getRole().getAuthority()));
		}
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		return grantedAuthorities;
	}
}