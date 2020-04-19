package com.irso.apialumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppAlumnosIrsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppAlumnosIrsoApplication.class, args);
		
	}
	
	
	/*
	 * @Bean public WebMvcConfigurer corsConfigurer() { return new
	 * WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET",
	 * "POST","PUT", "DELETE"); } }; }
	 */

}
