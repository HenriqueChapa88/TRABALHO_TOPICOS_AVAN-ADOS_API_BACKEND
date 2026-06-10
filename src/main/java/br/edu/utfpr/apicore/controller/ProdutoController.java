package br.edu.utfpr.apicore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.utfpr.apicore.dto.ProdutoDTO;
import br.edu.utfpr.apicore.model.Produto;
import br.edu.utfpr.apicore.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@Tag(name = "Produtos", description = "Recurso responsável pelo gerenciamento de produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Operation(
            summary = "Buscar produto por ID",
            description = "Retorna um produto específico a partir do seu identificador."
    )
    @GetMapping("/{id}")
    public Produto get(
            @Parameter(description = "ID do produto", example = "1")
            @PathVariable Long id) {
        return produtoService.findById(id);
    }

    @Operation(
            summary = "Atualizar produto",
            description = "Atualiza os dados de um produto existente pelo ID."
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @Parameter(description = "ID do produto que será atualizado", example = "1")
            @PathVariable Long id,
            @Valid @RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.update(id, dto));
    }

    @Operation(
            summary = "Excluir produto",
            description = "Remove um produto do sistema pelo ID."
    )
    @DeleteMapping("/{id}")
    public void delete(
            @Parameter(description = "ID do produto que será removido", example = "1")
            @PathVariable Long id) {
        produtoService.delete(id);
    }

    @Operation(
            summary = "Listar todos os produtos",
            description = "Retorna todos os produtos cadastrados no sistema."
    )
    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(200).body(produtoService.getAll());
    }

    @Operation(
            summary = "Cadastrar produto",
            description = "Cria um novo produto no sistema."
    )
    @PostMapping
    public Produto create(@Valid @RequestBody ProdutoDTO dto) {
        return produtoService.create(dto);
    }
}