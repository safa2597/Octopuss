package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;

public interface IuserService{
	User saveUser(User u);
	User findUserByUserName(String userName);

}
