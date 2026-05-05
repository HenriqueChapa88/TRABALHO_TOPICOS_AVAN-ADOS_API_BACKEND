package br.edu.utfpr.apicore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_produto")
@Data

public class Produto extends BaseEntity {

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;
    private String descricao;
    private Double valor;

}
    