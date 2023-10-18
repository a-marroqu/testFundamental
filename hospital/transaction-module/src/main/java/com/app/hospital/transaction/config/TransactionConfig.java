package com.app.hospital.transaction.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.ws.rs.core.Application;

@Configuration
@ComponentScan({"com.app.hospital.data"})
@EntityScan({"com.app.hospital.data"})
@EnableJpaRepositories({"com.app.hospital.data"})
public class TransactionConfig extends Application {
}
