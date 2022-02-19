package tn.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.UserRepository;

public class UserService implements IuserService{
	
	@Autowired
	UserRepository ur;

	@Override
	public User saveUser(User u) {
		return ur.save(u);
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
