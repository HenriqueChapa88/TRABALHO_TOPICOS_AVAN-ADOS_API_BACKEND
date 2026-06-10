package br.edu.utfpr.apicore.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Schema(description = "Dados necessários para cadastro ou atualização de um produto")
public record ProdutoDTO(

        @Schema(description = "Nome do produto", example = "Soja")
        @NotBlank
        @Size(min = 2, max = 100)
        String nome,

        @Schema(description = "Descrição detalhada do produto", example = "Saca de soja 60kg")
        @NotBlank
        @Size(min = 5, max = 255)
        String descricao,

        @Schema(description = "Valor unitário do produto", example = "150.00")
        @NotNull
        Double valor
) {
}