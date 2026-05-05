package br.edu.utfpr.apicore.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.apicore.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    public Page<Produto> findByNomeContainingIgnoreCase(String nome, Pageable pageable);
}