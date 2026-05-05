package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.apicore.dto.ItemPedidoDTO;
import br.edu.utfpr.apicore.model.ItemPedido;
import br.edu.utfpr.apicore.service.ItemPedidoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itempedido")
@Tag(name = "itempedido", description = "item pedido resource endpoints")
public class ItemPedidoController {

    @Autowired private ItemPedidoService itemPedidoService;

    @GetMapping("/{id}")
    public ItemPedido get(@PathVariable Long id) {
        return itemPedidoService.findById(id);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(itemPedidoService.getAll());
    }

    @PostMapping
    public ItemPedido create(@Valid @RequestBody ItemPedidoDTO dto) {
        return itemPedidoService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody ItemPedidoDTO dto) {
        return ResponseEntity.ok(itemPedidoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        itemPedidoService.delete(id);
    }
}