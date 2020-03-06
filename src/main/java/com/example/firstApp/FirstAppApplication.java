package com.example.firstApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FirstAppApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FirstAppApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);

		//Book myBook = new Book(1515631L, "testBook", "Declan", "IBNBJB54677");
	}

}
