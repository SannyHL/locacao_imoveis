package br.com.locacao.imoveis.configurations;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket getDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.locacao.imoveis.controller"))
                .build().apiInfo(informacoes());
    }

    private ApiInfo informacoes(){
        return new ApiInfoBuilder()
                .title("Controle Locação")
                .version("1.0")
                .description("Api Rest para controle de locação de imoveis")
                .contact(new Contact("Sanny Helen Lima", "https://github.com/SannyHL","sannyhelenlima@gmail.com"))
                .build();
    }
}
