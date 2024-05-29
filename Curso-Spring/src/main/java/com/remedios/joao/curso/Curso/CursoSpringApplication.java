package com.remedios.joao.curso.Curso;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "swagger OpenApi ", version= "1", description = "Api de remedios"))
//Link Swagger => http://localhost:8081/swagger-ui/index.html#/
@EnableScheduling
public class CursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
	}

}
