package com.irso.apialumnos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import com.irso.apialumnos.swagger.SwaggerConfig;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class AppAlumnosIrsoApplication implements CommandLineRunner{
	
	@Autowired
	private BCryptPasswordEncoder passwordEncode;

	public static void main(String[] args) {
		SpringApplication.run(AppAlumnosIrsoApplication.class, args);
		
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
 
           registry.addResourceHandler("swagger-ui.html")
                   .addResourceLocations("classpath:/META-INF/resources/");
 
    }
	

	public void run(String... args) throws Exception {
		String password = "irsotest";
		
		for (int i = 0; i < 4; i++) {
			String passwordBCrypt = passwordEncode.encode(password);
			System.out.println(passwordBCrypt);
			
		}
		
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
