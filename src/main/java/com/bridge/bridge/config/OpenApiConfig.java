package com.bridge.bridge.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenConfig() {

        return new OpenAPI()
                .addSecurityItem(
                        new SecurityRequirement()
                                .addList("bearerAuth")
                ).components(
                        new Components()
                                .addSecuritySchemes(
                                        "bearerAuth",
                                        new SecurityScheme()
                                                .name("bearerAuth")
                                                .type( SecurityScheme.Type.HTTP)
                                                .scheme("bearer")
                                                .bearerFormat("JWT")
                                )
                )
                ;
    }
}