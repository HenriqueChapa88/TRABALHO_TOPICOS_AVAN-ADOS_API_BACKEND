package br.edu.utfpr.apicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.apicore.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}