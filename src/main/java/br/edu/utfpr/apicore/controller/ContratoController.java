package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.apicore.dto.ContratoDTO;
import br.edu.utfpr.apicore.model.Contrato;
import br.edu.utfpr.apicore.service.ContratoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/contrato")
@Tag(name = "contrato", description = "contrato resource endpoints")
public class ContratoController {

    @Autowired private ContratoService contratoService;

    @GetMapping("/{id}")
    public Contrato get(@PathVariable Long id) {
        return contratoService.findById(id);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(contratoService.getAll());
    }

    @PostMapping
    public Contrato create(@Valid @RequestBody ContratoDTO dto) {
        return contratoService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody ContratoDTO dto) {
        return ResponseEntity.ok(contratoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        contratoService.delete(id);
    }
}