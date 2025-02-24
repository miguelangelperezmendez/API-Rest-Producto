package com.MicroServicioDB;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;




        // ESTA ES LA CONFIGURACION PARA USAR SWAGGER EN NUESTRO PROYECTO
@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    /* 
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }*/
}
