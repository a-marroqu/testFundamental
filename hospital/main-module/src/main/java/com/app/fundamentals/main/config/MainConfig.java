package com.app.fundamentals.main.config;

import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Configuration
@ComponentScan(
        {
                "com.app.fundamentals.data",
                "com.app.fundamentals.main"
        }
)
//TODO: averiguar porqué no funciono, algún día
//@ApplicationPath("/Rosell")
public class MainConfig extends Application {
}
