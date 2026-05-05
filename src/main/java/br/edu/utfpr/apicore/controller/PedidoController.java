package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.apicore.dto.PedidoDTO;
import br.edu.utfpr.apicore.model.Pedido;
import br.edu.utfpr.apicore.service.PedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedido")
@Tag(name = "pedido", description = "pedido resource endpoints")
public class PedidoController {

    @Autowired private PedidoService pedidoService;

    @GetMapping("/{id}")
    public Pedido get(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(pedidoService.getAll());
    }

    @PostMapping
    public Pedido create(@Valid @RequestBody PedidoDTO dto) {
        return pedidoService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody PedidoDTO dto) {
        return ResponseEntity.ok(pedidoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        pedidoService.delete(id);
    }
}