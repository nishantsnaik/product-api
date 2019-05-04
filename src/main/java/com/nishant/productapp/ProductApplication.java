package com.nishant.productapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
*/
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//clear@EnableSwagger2
public class ProductApplication {
/*
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES= new HashSet<String>(Arrays.asList("application/json","application/xml"));
*/

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
/*
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).useDefaultResponseMessages(false).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiInfo()).produces(DEFAULT_PRODUCES_AND_CONSUMES);
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"Product Management API",
				"APIs to manage the product data",
				"1.0",
				"Terms of service",
				new Contact("Nishant Naik", "www.example.com", "myeaddress@company.com"),


		*/

}
