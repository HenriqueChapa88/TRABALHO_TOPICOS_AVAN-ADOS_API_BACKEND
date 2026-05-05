package br.edu.utfpr.apicore.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record ClienteDTO(
    @NotBlank
    @Size(min = 2, max = 100)
    String name,
    
    @PastOrPresent //PASSADO OU PRESENTE
    LocalDate birth,
    
    @NotBlank
    String cpf,
    
    String endereco) {
}