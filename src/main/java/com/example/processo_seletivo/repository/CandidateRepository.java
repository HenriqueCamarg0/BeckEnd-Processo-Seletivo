package com.example.processo_seletivo.repository;

import com.example.processo_seletivo.model.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidato, Long> {
}
