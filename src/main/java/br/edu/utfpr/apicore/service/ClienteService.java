package br.edu.utfpr.apicore.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apicore.dto.ClienteDTO;
import br.edu.utfpr.apicore.exception.NotFoundException;
import br.edu.utfpr.apicore.model.Cliente;
import br.edu.utfpr.apicore.repository.ClienteRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente create(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(dto, cliente);
        return clienteRepository.save(cliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new NotFoundException("Cliente not found"));
    }

    @Transactional
  public void delete(Long id) {
        Cliente cliente = findById(id);

        // Quebra o vínculo com os pedidos antes de deletar
        if (cliente.getPedidos() != null) {
            cliente.getPedidos().forEach(pedido -> pedido.setCliente(null));
        }

        clienteRepository.delete(cliente);
    }

    public Page<Cliente> getByName(String name, Pageable pageable) {
        return clienteRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Cliente update(Long id, ClienteDTO dto) {
        var entity = findById(id);
        BeanUtils.copyProperties(dto, entity, "id");
        return clienteRepository.save(entity);
    }
}