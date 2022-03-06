package tn.esprit.spring.iservices;

import java.util.List;

import tn.esprit.spring.entities.User;

public interface IUserService {
	
	public User addUser(User u);
	public User updateUser(User u);
	public User findUserByUserName(String username);
	public List<User> getAllUser();
	public List<User> getUndeletedUser();
	public List<User> getdeletedUser();
	public User getUserById(Long id);
	public void deleteUserById(Long id);
	public User BlocUser(User u );
	public void sendSimpleEmail(String toEmail,String body,String subject);
	public void lockedUser(Long id) ;
		
	
	

}
