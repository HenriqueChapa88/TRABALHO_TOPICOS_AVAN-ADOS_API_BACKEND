package br.edu.utfpr.apicore.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//Objeto de transferência de dados
//Dados imutáveis
public record ProdutoDTO(
    @NotBlank
    @Size(min = 2, max = 100)
    String nome,

    @NotBlank
    @Size(min = 5, max = 255)
    String descricao,

    @NotNull
    Double valor) {
}
