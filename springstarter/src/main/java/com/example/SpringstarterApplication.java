package com.example;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.domain.Journal;
import com.example.repository.JournalRepository;

@SpringBootApplication
public class SpringstarterApplication {
	
	@Bean
	InitializingBean saveData(JournalRepository repo){
		return () -> {
			repo.save(new Journal("Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
			repo.save(new Journal("Simple Spring Boot Project","I will do my first Spring Boot Project","01/02/2016"));
			repo.save(new Journal("Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
			repo.save(new Journal("Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
		};
	}
	
	
	
	@Bean
	CommandLineRunner init(JournalRepository repo){
		return args -> {
			System.out.println("---------------------------------");
	        repo.findAll().forEach(System.out::println);
	        System.out.println("---------------------------------");
		};
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringstarterApplication.class, args);
	}
}
