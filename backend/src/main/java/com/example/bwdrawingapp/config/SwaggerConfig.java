package com.example.bwdrawingapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.bwdrawingapp.controller")) // Укажи пакет с контроллерами
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(Collections.singletonList(createAuthorizationHeader()));
    }

    private Parameter createAuthorizationHeader() {
        return new Parameter(
                "Authorization", // Имя параметра
                "Bearer token", // Пример значения (можно оставить как пример, а не реальные данные)
                "JWT токен для авторизации", // Описание параметра
                true, // Необходим ли параметр (true, если обязательный)
                false, // Если false, параметр не обязателен для запроса
                null, // Параметры типа (можно оставить null, если не используется)
                new ModelRef("string"), // Тип данных, в данном случае строка
                null,
                null,
                null,
                null,
                false,
                null,
                null,
                0,
                null,
                null,
                null,
                null,
                false,
                false
        );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Black & White Drawing App API")
                .description("API для рисования черно-белых рисунков и управления аккаунтом пользователя")
                .version("1.0")
                .build();
    }
}