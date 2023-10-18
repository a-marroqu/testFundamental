package com.app.hospital.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

	//AHORA ESTO SE HACE EN TRANSACTION-MODULE
//	private PatientRepository repository;
//
//	public MainApp(PatientRepository repository) {
//		this.repository = repository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	//COMENTADO PORQUE AHORA SE HAN MOVIDO LAS CLASES
//	@Bean
//	public CommandLineRunner test() {
//		PatientService patientService = new PatientService(repository);
//		return (args) -> patientService.addPatient();
//	}

}
