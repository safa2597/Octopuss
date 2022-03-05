package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.iservices.IUserService;
import tn.esprit.spring.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepo;
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	@Autowired
	private JavaMailSender mailSender;
	@Override
	public User addUser(User u) {
		u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
		u.setActive(true);
		return userRepo.save(u);
	}
	@Override
	public User updateUser(User u) {
		return this.userRepo.save(u);
	}
	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
	}
	@Override
	public User getUserById(Long id) {
		return userRepo.getById(id);
	}
	@Override
	public void deleteUserById(Long id) {
		userRepo.deleteById(id);	
	}
    @Override
	public User findUserByUserName(String username) {	
        return userRepo.findByUserName(username);
    }
	@Override
	public User BlocUser(User u) {
		int x = u.getWarningNum();
		if(x>3){
			u.setLocked(true);
			return userRepo.save(u);
		}
		else return userRepo.save(u);
		
	}
	@Override
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message= new SimpleMailMessage();
		
		message.setFrom("fatma.nagati@esprit.tn");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		System.out.println("Mail send ..");
		
	}



}
