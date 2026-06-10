package br.edu.utfpr.apicore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_produto")
@Data
@Schema(description = "Entidade que representa um produto comercializado")
public class Produto extends BaseEntity {

    @Schema(description = "Nome do produto", example = "Soja")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Schema(description = "Descrição do produto", example = "Saca de soja 60kg")
    private String descricao;

    @Schema(description = "Valor do produto", example = "150.00")
    private Double valor;
}