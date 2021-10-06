package pl.sda.askanything;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AskAnythingApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskAnythingApplication.class, args);
    }

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //create documentation only for classes with @RestController annotation
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
}
