package br.edu.utfpr.apicore.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public record PedidoDTO(
    String descricao,
    
    @NotNull
    LocalDate data,
    
    @NotNull
    Long clienteId) {
    }