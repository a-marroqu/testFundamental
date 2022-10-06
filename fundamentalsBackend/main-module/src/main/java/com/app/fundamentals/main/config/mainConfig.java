package com.app.fundamentals.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Configuration
@ComponentScan(
        {
            "com.app.fundamentals.data"
        }
)
@ApplicationPath("/hospital")
public class mainConfig extends Application {
}
