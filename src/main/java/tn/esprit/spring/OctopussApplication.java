package tn.esprit.spring;



import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;






@EnableScheduling
@SpringBootApplication
public class OctopussApplication extends WebMvcConfigurerAdapter  {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}


	public static void main(String[] args) {
		SpringApplication.run(OctopussApplication.class, args);
		
		
		
	
	}
	
	
	
	
	
	
	

}


