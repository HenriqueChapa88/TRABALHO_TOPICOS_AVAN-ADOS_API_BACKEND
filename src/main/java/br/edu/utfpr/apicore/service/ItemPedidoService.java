package br.edu.utfpr.apicore.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apicore.dto.ItemPedidoDTO;
import br.edu.utfpr.apicore.exception.NotFoundException;
import br.edu.utfpr.apicore.model.ItemPedido;
import br.edu.utfpr.apicore.repository.ItemPedidoRepository;
import br.edu.utfpr.apicore.repository.PedidoRepository;
import br.edu.utfpr.apicore.repository.ProdutoRepository;

@Service
public class ItemPedidoService {

    @Autowired private ItemPedidoRepository itemPedidoRepository;
    @Autowired private PedidoRepository pedidoRepository;
    @Autowired private ProdutoRepository produtoRepository;

    public ItemPedido create(ItemPedidoDTO dto) {
        ItemPedido item = new ItemPedido();
        BeanUtils.copyProperties(dto, item);
        
        if(dto.pedidoId() != null) item.setPedido(pedidoRepository.findById(dto.pedidoId()).orElseThrow());
        if(dto.produtoId() != null) item.setProduto(produtoRepository.findById(dto.produtoId()).orElseThrow());
        
        return itemPedidoRepository.save(item);
    }

    public List<ItemPedido> getAll() {
        return itemPedidoRepository.findAll();
    }

    public ItemPedido findById(Long id) {
        return itemPedidoRepository.findById(id).orElseThrow(() -> new NotFoundException("Item not found"));
    }

    public void delete(Long id) {
        itemPedidoRepository.deleteById(id);
    }

    public ItemPedido update(Long id, ItemPedidoDTO dto) {
        var entity = findById(id);
        BeanUtils.copyProperties(dto, entity, "id");
        if(dto.pedidoId() != null) entity.setPedido(pedidoRepository.findById(dto.pedidoId()).orElseThrow());
        if(dto.produtoId() != null) entity.setProduto(produtoRepository.findById(dto.produtoId()).orElseThrow());
        
        return itemPedidoRepository.save(entity);
    }
}