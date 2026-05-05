package br.edu.utfpr.apicore.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apicore.dto.ContratoDTO;
import br.edu.utfpr.apicore.exception.NotFoundException;
import br.edu.utfpr.apicore.model.Contrato;
import br.edu.utfpr.apicore.repository.ContratoRepository;
import br.edu.utfpr.apicore.repository.PedidoRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContratoService {

    @Autowired private ContratoRepository contratoRepository;
    @Autowired private PedidoRepository pedidoRepository;

    public Contrato create(ContratoDTO dto) {
        Contrato contrato = new Contrato();
        BeanUtils.copyProperties(dto, contrato);
        
        if(dto.pedidoId() != null) {
            contrato.setPedido(pedidoRepository.findById(dto.pedidoId())
                .orElseThrow(() -> new NotFoundException("Pedido not found")));
        }
        return contratoRepository.save(contrato);
    }

    public List<Contrato> getAll() {
        return contratoRepository.findAll();
    }

    public Contrato findById(Long id) {
        return contratoRepository.findById(id).orElseThrow(() -> new NotFoundException("Contrato not found"));
    }

    @Transactional
   public void delete(Long id) {
        Contrato contrato = findById(id);

        // Avisa o Pedido que ele não tem mais esse contrato
        if (contrato.getPedido() != null) {
            contrato.getPedido().setContrato(null);
        }

        contratoRepository.delete(contrato);
    }

    public Contrato update(Long id, ContratoDTO dto) {
        var entity = findById(id);
        BeanUtils.copyProperties(dto, entity, "id");
        if(dto.pedidoId() != null) {
            entity.setPedido(pedidoRepository.findById(dto.pedidoId())
                .orElseThrow(() -> new NotFoundException("Pedido not found")));
        }
        return contratoRepository.save(entity);
    }
}