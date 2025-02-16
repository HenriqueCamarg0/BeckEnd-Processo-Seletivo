package com.example.processo_seletivo.repository;

import com.example.processo_seletivo.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidatoRepository extends JpaRepository<Candidato, Long> {
    Optional<Candidato> findByNomeOrEmailOrTelefone(String nome, String email, String telefone);
}