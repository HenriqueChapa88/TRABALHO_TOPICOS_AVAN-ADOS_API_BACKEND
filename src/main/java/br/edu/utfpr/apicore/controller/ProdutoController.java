package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.apicore.dto.ProdutoDTO;
import br.edu.utfpr.apicore.model.Produto;
import br.edu.utfpr.apicore.service.ProdutoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@Tag(name = "produto", description = "produto resource endpoints")
public class ProdutoController {

    @Autowired private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Produto get(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<Object> getAll() {
        return ResponseEntity.status(200).body(produtoService.getAll());
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<Object> getByName(@PathVariable String nome, Pageable pageable) {
        return ResponseEntity.status(206).body(produtoService.getByName(nome, pageable));
    }

    @PostMapping
    public Produto create(@Valid @RequestBody ProdutoDTO dto) {
        return produtoService.create(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        produtoService.delete(id);
    }
}