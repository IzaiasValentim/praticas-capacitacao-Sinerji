package com.izaiasvalentim.projeto_security_jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2

// Configurações da interface swagger para a aplicação.
public class SwaggerConfig {
    @Bean
    // Criação e configuração do docket.
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.izaiasvalentim.projeto_security_jwt.controllers"))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(Arrays.asList(securityContext()))
                .securitySchemes(Arrays.asList(apiKey()))
                .apiInfo(apiInfo());
    }

    // Define informações gerais sobre a API.
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Projeto Spring Security-JWT")
                .description("Capacitação Sinerji")
                .version("1.0")
                .contact(contact())
                .build();
    }

    // Fornece detalhes do meu contato.
    private Contact contact() {
        return new Contact("Luis Izaias",
                "https://github.com/IzaiasValentim", "izaias451@gmail.com");
    }

    // Configura um esquema de segurança do tipo ApiKey para usar JWT no cabeçalho de autorização.
    public ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    // Define o contexto de segurança para a API, associando referências de segurança aos caminhos.
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build();
    }

    // Configura a autorização padrão, permitindo acesso global a todos os recursos.
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope(
                "global", "accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = authorizationScope;
        SecurityReference reference = new SecurityReference("JWT", scopes);
        List<SecurityReference> auths = new ArrayList<>();
        auths.add(reference);
        return auths;
    }
}
