package com.sheet.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan("com.poc.mongodb.mongodbapi.controller")
public class SwaggerConfig {
	
	public static final String DEFAULT_INCLUDE_PATTERNS = "/api/.*";
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(
           RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
    }
	


}
