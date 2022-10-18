package com.app.fundamentals.main;

import com.app.fundamentals.data.repository.PatientRepository;
import com.app.fundamentals.main.config.MainConfig;
import com.app.fundamentals.main.service.PatientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

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
