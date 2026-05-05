package br.edu.utfpr.apicore.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public record ContratoDTO(
    String descricao,
    
    @NotNull
    LocalDate dataContrato,
    
    @NotNull
    Long pedidoId) {
    }