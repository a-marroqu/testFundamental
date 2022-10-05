package com.app.fundamentals.main.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(
        {
            "com.app.fundamentals.data"
        }
)
public class mainConfig{
}
