package com.springboot.test.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

//    @Bean
//    public OpenAPI openAPI(){
//        return new OpenAPI()
//                .info(info());
//    }
//
//    @Bean
//    public Info info(){
//        return new Info()
//                .title("Spring Boot Open API Test with Swagger")
//                .description("swagger 테스트")
//                .version("1.0.0");
//    }

//    @Bean
//    public GroupedOpenApi api(){
//        return GroupedOpenApi.builder()
//                .group("product")
//                .packagesToScan("com.springboot.test.controller.ProductController")
//                .pathsToMatch("/product/**")
//                .build();
//    }


    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot Open API Test with Swagger")
                        .description("설명 부분")
                        .version("1.0.0")
                );
    }
}
