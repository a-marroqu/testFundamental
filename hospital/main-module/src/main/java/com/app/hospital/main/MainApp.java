package com.app.hospital.main;

import com.app.hospital.data.repository.PatientRepository;
import com.app.hospital.main.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApp {

	private PatientRepository repository;

	public MainApp(PatientRepository repository) {
		this.repository = repository;
	}

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public CommandLineRunner test() {
		PatientService patientService = new PatientService(repository);
		return (args) -> patientService.addPatient();
	}

}
