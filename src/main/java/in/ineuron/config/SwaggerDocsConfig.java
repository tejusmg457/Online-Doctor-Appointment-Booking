package in.ineuron.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerDocsConfig {

	@Bean
	public Docket createDocket() {
		return new Docket(DocumentationType.SWAGGER_2).// UI Screen type
				select(). // to specify RestControllers
				apis(RequestHandlerSelectors.basePackage("in.ineuron.controller"))// base packages for controller
				.paths(PathSelectors.regex("/api/.*")).// To specify the request paths
				build()// build the docket object
				.useDefaultResponseMessages(true).apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		Contact contact = new Contact("TEJAS", "https://google.com", "tejasrhonnali457@gmail.com");
		return new ApiInfo("Appointment booking app", "Used to book appointments with doctor", "1.0.RELEASE", "http:", contact,
				"GNU PUBLIC", "http://apache.org/license/guru", Collections.emptyList());
	}

}

