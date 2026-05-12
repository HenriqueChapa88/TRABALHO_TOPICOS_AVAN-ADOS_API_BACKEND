package br.edu.utfpr.apicore.service;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.edu.utfpr.apicore.dto.ProdutoDTO;
import br.edu.utfpr.apicore.exceptions.NotFoundException;
import br.edu.utfpr.apicore.model.Produto;
import br.edu.utfpr.apicore.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto create(ProdutoDTO dto) {
        Produto produto = new Produto();
        BeanUtils.copyProperties(dto, produto);
        return produtoRepository.save(produto);
    }

    public List<Produto> getAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new NotFoundException("Produto not found"));
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }

    public Page<Produto> getByName(String nome, Pageable pageable) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome, pageable);
    }

    public Produto update(Long id, ProdutoDTO dto) {
        var entity = findById(id);
        BeanUtils.copyProperties(dto, entity, "id");
        return produtoRepository.save(entity);
    }
}