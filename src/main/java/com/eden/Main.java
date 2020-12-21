package com.eden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class Main.
 */
@SuppressWarnings("deprecation")
@EnableSwagger2
@SpringBootApplication
@EnableJpaRepositories("com.eden.*")
@ComponentScan(basePackages = { "com.eden.*" })
@EntityScan("com.eden.*")
public class Main extends WebMvcConfigurerAdapter {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	/**
	 * Docket.
	 *
	 * @return the docket
	 */
	@Bean
	public Docket docket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(getClass().getPackage().getName())).paths(PathSelectors.any())
				.build().apiInfo(generateApiInfo());
	}

	/**
	 * Generate api info.
	 *
	 * @return the api info
	 */
	private ApiInfo generateApiInfo() {
		return new ApiInfo("Eden Ecommerce Server Applicant Test Service",
				"This service is to check the technology knowledge of a server.", "Version 1.0 - mw", "urn:tos",
				"career@egen.com", "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0");
	}
}
