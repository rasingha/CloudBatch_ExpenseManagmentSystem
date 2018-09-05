package com.cg.expense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;


/************************************************************************************
 * File:  	 ExpenseApplication.java
 * Package:  com.cg.expense
 * Desc: 	 Main class for the Module: Expense Code
 * Version:  1.0
 * Modifications: -
 * Author: Kavya Lekhana Gurramkonda  Date:  29-August-2018   Change Description: -
 ************************************************************************************/


@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan("com.cg.expense")
public class ExpenseApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ExpenseApplication.class, args);
	}
	@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
	{
        return builder.build();
    }
}
