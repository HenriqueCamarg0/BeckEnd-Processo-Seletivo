package com.example.processo_seletivo.service;

import com.example.processo_seletivo.dto.CandidatoDTO;
import com.example.processo_seletivo.model.Candidato;
import com.example.processo_seletivo.model.StatusCandidato;
import com.example.processo_seletivo.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CandidatoService {
    private final CandidatoRepository repository;

    public Candidato cadastrar(CandidatoDTO dto) {
        Candidato candidato = new Candidato();
        candidato.setNome(dto.getNome());
        candidato.setEmail(dto.getEmail());
        candidato.setSalarioPretendido(dto.getSalarioPretendido());
        candidato.setTelefone(dto.getTelefone());
        candidato.setVaga(dto.getVaga());
        candidato.setStatus(StatusCandidato.EM_ANALISE);
    Candidato savedCandidato = repository.save(candidato);
   
    // Imprimindo o resultado no terminal
    System.out.println("Candidato cadastrado: " + savedCandidato);
     return savedCandidato;
}
    public List<Candidato> listarTodos() {
        return repository.findAll();
    }

    public Candidato obterPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Candidato não encontrado"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}