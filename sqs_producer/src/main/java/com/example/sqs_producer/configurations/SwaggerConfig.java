package com.example.sqs_producer.configurations;

import io.swagger.v3.core.converter.ModelConverters;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.webflux.core.converters.WebFluxSupportConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {

    ModelConverters.getInstance().addConverter(new WebFluxSupportConverter());

    return new OpenAPI()
        .components(new Components()
//            .addSecuritySchemes("JWE", new SecurityScheme()
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("bearer")
//                .bearerFormat("JWE"))
        ).info(new Info()
            .contact(
                new Contact()
                    .name("Nizami Islamovs")
                    .email("nizami.islamovs@gmail.com")
                    .url("https://github.com/nislamovs")
            ).description("This is SQS producer api swagger page")
            .version("1.0.0")
            .license(
                new License()
                    .name("Bullshit licence")
                    .url("No url :)")
             ).title("Product API")
        );
  }
}