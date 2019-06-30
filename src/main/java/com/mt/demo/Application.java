package com.mt.demo;

import java.util.Arrays;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public KieContainer kieContainer() {

		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
		// .securitySchemes(Arrays.asList(securityScheme()))
		// .securityContexts(Arrays.asList(securityContext()));
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().clientId("test").clientSecret("test").scopeSeparator(" ")
				.useBasicAuthenticationWithAccessCodeGrant(true).build();
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder()
				.securityReferences(Arrays.asList(new SecurityReference("spring_oauth", scopes())))
				.forPaths(PathSelectors.regex("/.*")).build();
	}

	/*
	 * private SecurityScheme securityScheme() { GrantType grantType = new
	 * AuthorizationCodeGrantBuilder() .tokenEndpoint(new TokenEndpoint(AUTH_SERVER
	 * + "/token", "oauthtoken")) .tokenRequestEndpoint( new
	 * TokenRequestEndpoint(AUTH_SERVER + "/authorize", CLIENT_ID, CLIENT_ID))
	 * .build();
	 * 
	 * SecurityScheme oauth = new OAuthBuilder().name("spring_oauth")
	 * .grantTypes(Arrays.asList(grantType)) .scopes(Arrays.asList(scopes()))
	 * .build(); return oauth; }
	 */

	private AuthorizationScope[] scopes() {
		AuthorizationScope[] scopes = { new AuthorizationScope("read", "for read operations"),
				new AuthorizationScope("write", "for write operations"),
				new AuthorizationScope("foo", "Access foo API") };
		return scopes;
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Spring Boot REST API").description("Spring boot basic REST API")
				.contact(new Contact("Manikandan", "mindtraits.com	", "manisnow@gmail.com")).license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html").version("1.0.0").build();
	}

}
