package br.edu.utfpr.apicore.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ItemPedidoDTO(
    @NotNull
    Long pedidoId,
    
    @NotNull
    Long produtoId,
    
    @Min(1)
    int quantidade,
    
    @NotNull
    double valorUnitario) {
    }