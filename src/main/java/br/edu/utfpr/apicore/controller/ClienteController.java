package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.apicore.dto.ClienteDTO;
import br.edu.utfpr.apicore.model.Cliente;
import br.edu.utfpr.apicore.service.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cliente")
@Tag(name = "cliente", description = "cliente resource endpoints")
public class ClienteController {

    @Autowired private ClienteService clienteService;

    @GetMapping("/{id}")
    public Cliente get(@PathVariable Long id) {
        return clienteService.findById(id);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(clienteService.getAll());
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Object> getByName(@PathVariable String name, Pageable pageable) {
        return ResponseEntity.status(206).body(clienteService.getByName(name, pageable));
    }

    @PostMapping
    public Cliente create(@Valid @RequestBody ClienteDTO dto) {
        return clienteService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody ClienteDTO dto) {
        return ResponseEntity.ok(clienteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        clienteService.delete(id);
    }
}