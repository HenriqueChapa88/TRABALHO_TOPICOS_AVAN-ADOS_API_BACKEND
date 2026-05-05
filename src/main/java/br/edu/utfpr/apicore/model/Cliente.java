package br.edu.utfpr.apicore.model;

import java.time.LocalDate;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tb_cliente")
@Data
public class Cliente extends BaseEntity {

    @Column(name = "name", length = 100, nullable = false)
    private String name;
    private LocalDate birth;
    private String cpf;
    private String endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;
}