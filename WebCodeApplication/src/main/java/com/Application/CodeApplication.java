package com.Application;

@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class CodeApplication {

	public static void main (String[] args) {
		System.setProperties("Server.port", "8080");
		SpringApplication.run(CodeApplication.class, args);
	}
	
	
}
