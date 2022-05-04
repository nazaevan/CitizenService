package com.mentoring.project.demo.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {
    @Value("${info.app.version:v1.0.0}")
    private String version;

    @Bean
    public OpenAPI apiEndPointsInfo() {
        License license = new License();
        license.setName("This project is property of Wizeline.");
        return new OpenAPI()
            .components(new Components())
            .info(new Info().version(version).license(license).title("Citizen Microservices").description(
                "Citizen Microservices: mentoring project"));
    }
}
