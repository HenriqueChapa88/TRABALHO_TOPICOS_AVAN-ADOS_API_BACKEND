package br.edu.utfpr.apicore.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_contrato")
@Data
public class Contrato extends BaseEntity {

    private String descricao;
    private LocalDate dataContrato;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
