package com.cg.ems.ProjectCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("com.cg.ems")
public class ProjectCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectCodeApplication.class, args);
	}
	
	
}
