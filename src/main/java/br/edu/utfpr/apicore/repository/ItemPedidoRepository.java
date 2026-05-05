package br.edu.utfpr.apicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.apicore.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}