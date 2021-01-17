package com.JoinTheClub.Study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
  
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}
		 
	 @GetMapping("/home")
	 public String home(@RequestParam(value = "name", defaultValue = "join the Club") String name) {
		 return String.format("Welcome to my Home Page %s!", name);
	 }

}
