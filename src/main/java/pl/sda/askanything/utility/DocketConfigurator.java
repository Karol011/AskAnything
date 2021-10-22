package pl.sda.askanything.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
@Configuration
public class DocketConfigurator {

    @Bean
    public Docket get() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //create documentation only for classes with @RestController annotation
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
}
