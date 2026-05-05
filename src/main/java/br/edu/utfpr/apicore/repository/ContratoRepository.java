package br.edu.utfpr.apicore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.utfpr.apicore.model.Contrato;

public interface ContratoRepository extends JpaRepository<Contrato, Long> {
}