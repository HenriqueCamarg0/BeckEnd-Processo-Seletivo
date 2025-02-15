package com.example.processo_seletivo.service;

import com.example.processo_seletivo.dto.CandidatoDTO;
import com.example.processo_seletivo.model.Candidato;
import com.example.processo_seletivo.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatoService {
    private final CandidateRepository repository;

    public Candidato cadastrar(CandidatoDTO dto) {
        // lógica de cadastro
        Candidato candidato = new Candidato();
        candidato.setNome(dto.getEmail());
        candidato.setEmail(dto.getNome());
        return repository.save(candidato);
    }

    public List<Candidato> listarTodos() {
        return repository.findAll();
    }
    
    public Candidato obterPorId(Long id) {
         return repository.findById(id).orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
    }    
}
