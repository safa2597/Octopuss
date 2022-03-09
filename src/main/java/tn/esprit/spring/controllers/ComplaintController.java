package tn.esprit.spring.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.ChatBotRate;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Expert;
import tn.esprit.spring.entities.Oppointment;
import tn.esprit.spring.entities.StatReclamation;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repositories.ChatBotRepository;
import tn.esprit.spring.repositories.ExpertRepository;
import tn.esprit.spring.repositories.OppointmentRepository;
import tn.esprit.spring.repositories.UserRepository;
import tn.esprit.spring.services.IComplaintService;
import tn.esprit.spring.services.UserService;

@RestController
@Api(tags = "Gestion des complaint")
@RequestMapping("/complaint")
public class ComplaintController {
	@Autowired
	private IComplaintService ics;
	@Autowired
	private ExpertRepository expertrepos;
	@Autowired
	private ChatBotRepository chatBotRepository;
	@Autowired
	private OppointmentRepository oppointmentRepository;
	private String question;
	private String expertType;
	private String rate;
	
	@PostMapping("addComplaint")
	@ResponseBody
	public void addComplaint(@RequestBody Complaint c) {
	ics.addComplaint(c);
	}
	
	
	
	@DeleteMapping("/delete-Complain/{idC}")
	@ResponseBody
	public void deleteComplaint(@PathVariable Long idC){
		ics.deleteComplaint(idC);}
		
		@GetMapping("/retrieve-all-Complaints")
		@ResponseBody
		public List<Complaint> getComplaints() {
		return ics.findComplaints();
		}
		
		@PutMapping("/modify-Complaint")
		public Complaint modifyComplaint(@RequestBody Complaint Complaint) {
		return ics.updateComplaint(Complaint);
		}
		
		@PutMapping("/affectUserComplaint/{id-user}/{id-complaint}")
		public void affecterUserComplaint(@PathVariable("id-user") Long idUser,@PathVariable("id-complaint") Long idC){
			ics.affecterComplainttoUser(idUser, idC);
		}
	
		@PostMapping("/ChatBot")
		public String chatbot(@RequestParam("reponse") String reponse) throws ParseException
		{
			if(reponse.equals("Hi"))
			{
				question="whats your case ? \nViolance \nMental Health\nHospitalization \nLegalization";
				return question;
			}
			if(reponse.equals("Violance"))
			{
				question="do you want to contact an expert ? -police station-(Y/N)";
				expertType="police";
				return question;
			}
			else if(reponse.equals("Mental Health"))
			{
				question="do you want to contact an expert ? -therapist-(Y/N)";
				expertType="therapist";
				return question;
			}
			else if(reponse.equals("Hospitalization"))
			{
				question="do you want to contact an expert ? -Doctor-(Y/N)";
				expertType="doctor";
				return question;
			}
			else if(reponse.equals("Legalization"))
			{
				question="do you want to contact an expert ? -Lawyer-(Y/N)";
				expertType="lawyer";
				return question;
			}
			
			if((question.equals("do you want to contact an expert ? -police station-(Y/N)"))||(question.equals("do you want to contact an expert ? -therapist-(Y/N)"))||(question.equals("do you want to contact an expert ? -Doctor-(Y/N)"))||(question.equals("do you want to contact an expert ? -Lawyer-(Y/N)")))
			{
				if(reponse.equals("Y"))
				{
					//affecter l'utilisateur a un rendez vous avec l'expert
					
					
					question="state the date you want to get appointment at";
					return  question;
				}
				else if(reponse.equals("N"))
				{
					question="do you want to pass a claim?(Y/N)";
					return question;
				}else
				{
					return "please answer with Y or N";
				}
			}
			
			if(question.equals("do you want to pass a claim?(Y/N)"))
			{
				if(reponse.equals("Y")){
					//creation d'une reclamation system
					Complaint compSys = new Complaint();
					
					//date de creation de reclamation
					LocalDate current= LocalDate.now();
					ZoneId systemTimeZone = ZoneId.systemDefault();
					ZonedDateTime zonedDateTime = current.atStartOfDay(systemTimeZone);
					Date currentDate = Date.from(zonedDateTime.toInstant());
					
					compSys.setSendDate(currentDate);
					compSys.setObject("System Complaint");
					compSys.setStatus(StatReclamation.NON_TRAITER);
					String textC = "";
					if(expertType.equals("police")){textC=textC+" Violance Case ";}
					else if(expertType.equals("therapist")){textC=textC+" Mental Health Case. ";}
					else if(expertType.equals("doctor")){textC=textC+" Hospitalization Case. ";}
					else if(expertType.equals("lawyer")){textC=textC+" Legalisation Case. ";}
					
					//current User 
					User user = new User();
					user.setId((long)1);
					
					compSys.setUser(user);
					
					compSys.setTextC(textC);
					
					ics.addComplaint(compSys);
					
					//api mailing if u want
					
					rate="yes";
					question="";
					return "You have passed a system claim successfuly , check your claims for details \nChat Bot ends here\nTo reboot chatbot type Hi\n if you want to rate our Chat Bot? (1-5)";
				}else if (reponse.equals("N"))
				{
					question="";
					return "I hope we helped you! \nChat Bot ends here\nTo reboot chatbot type Hi";
				}else
				{
					return "please answer with Y or N";
				}
			}
			if(question.equals("state the date you want to get appointment at"))
			{
				//converting reponse to date 
				 
				Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(reponse);
				Oppointment opoint= new Oppointment();
				List<Expert> expert = expertrepos.findByExpertType(expertType);
				
				for(int i=0;i<expert.size();i++)
				{	
					boolean available=true;
					List<Oppointment> oppointments = oppointmentRepository.findByExpert(expert.get(i));
					for(int j=0;j<oppointments.size();j++)
					{
						if(oppointments.get(j).getOpDate().compareTo(date1)==0)
						{
							available=false;
							break;
						}
					}
					if(available==true)
					{
						//current User 
						User user = new User();
						user.setId((long)1);
						opoint.setExpert(expert.get(i));
						opoint.setOpDate(date1);
						opoint.setUser(user);
						oppointmentRepository.save(opoint);
						question="";
						return "you have booked an appointment with Mr(s) "+expert.get(i).getNom()+".\nDate of appointment : "+date1+"\n to reboot chatbot say Hi!";
					}
				}
				question="state the date you want to get appointment at";
				return "we dont have availabe experts at the specific date , try another date ";
				    
			}
			if(rate.equals("yes"))
			{
				//current User 
				User user = new User();
				user.setId((long)1);
				
				int stars =Integer.parseInt(reponse);
				ChatBotRate rate =new ChatBotRate();
				rate.setStars(stars);
				rate.setUser(user);
				chatBotRepository.save(rate);
				return "Thank you for Rating our ChatBot ! \nTo reboot chatbot type Hi\n";
			}
			return question;
		}
	}