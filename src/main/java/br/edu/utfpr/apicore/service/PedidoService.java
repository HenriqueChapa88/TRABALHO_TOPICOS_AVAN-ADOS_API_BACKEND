package br.edu.utfpr.apicore.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apicore.dto.PedidoDTO;
import br.edu.utfpr.apicore.exception.NotFoundException;
import br.edu.utfpr.apicore.model.Pedido;
import br.edu.utfpr.apicore.repository.ClienteRepository;
import br.edu.utfpr.apicore.repository.PedidoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PedidoService {

    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ClienteRepository clienteRepository;

    public Pedido create(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        BeanUtils.copyProperties(dto, pedido);
        
        if(dto.clienteId() != null) {
            pedido.setCliente(clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new NotFoundException("Cliente not found")));
        }
        
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> getAll() {
        return pedidoRepository.findAll();
    }

    public Pedido findById(Long id) {
        return pedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Pedido not found"));
    }

    @Transactional
  public void delete(Long id) {
        // 1. Busca o pedido completo no banco de dados
        Pedido pedido = findById(id);

        // 2. Desvincula o contrato para o Hibernate não se perder
        if (pedido.getContrato() != null) {
            pedido.getContrato().setPedido(null);
        }

        // 3. Desvincula todos os itens do pedido
        if (pedido.getItens() != null) {
            pedido.getItens().forEach(item -> item.setPedido(null));
        }

        // 4. Agora sim, deleta o pedido com segurança (o cascade removerá os órfãos do banco)
        pedidoRepository.delete(pedido);
    }

    public Pedido update(Long id, PedidoDTO dto) {
        var entity = findById(id);
        BeanUtils.copyProperties(dto, entity, "id");
        if(dto.clienteId() != null) {
            entity.setCliente(clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new NotFoundException("Cliente not found")));
        }
        return pedidoRepository.save(entity);
    }
}