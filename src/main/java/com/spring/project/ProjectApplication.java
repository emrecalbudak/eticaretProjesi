package com.spring.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;

@SpringBootApplication
@EnableWebMvc
public class ProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API Başlığı")
						.version("1.0")
						.description("API açıklaması"));
	}

	@Bean
	public GroupedOpenApi api() {
		return GroupedOpenApi.builder()
				.group("project-api")
				.pathsToMatch("/api/**")
				.build();
	}
}
