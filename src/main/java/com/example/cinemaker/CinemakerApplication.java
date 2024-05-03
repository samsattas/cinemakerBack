package com.example.cinemaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class CinemakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemakerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				//Everything allowed for this local project, origins must be restricted for production!!!
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
			}
		};
	}

}
