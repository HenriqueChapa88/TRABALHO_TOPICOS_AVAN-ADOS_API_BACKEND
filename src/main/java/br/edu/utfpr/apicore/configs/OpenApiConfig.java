package br.edu.utfpr.apicore.configs;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Comercialização Agrícola")
                        .description("Documentação da API para gerenciamento de clientes, produtos, pedidos, itens de pedido, contratos e autenticação.")
                        .version("1.0.0"));
    }
}