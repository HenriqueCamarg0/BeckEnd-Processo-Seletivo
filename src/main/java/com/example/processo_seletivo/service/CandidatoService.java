package com.example.processo_seletivo.service;

import com.example.processo_seletivo.dto.CandidatoDTO;
import com.example.processo_seletivo.model.Candidato;
import com.example.processo_seletivo.model.StatusCandidato;
import com.example.processo_seletivo.repository.CandidatoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CandidatoService {
    private static final Logger logger = LoggerFactory.getLogger(CandidatoService.class);
    private final CandidatoRepository repository;

    public Candidato cadastrar(CandidatoDTO dto) {
        // Verificar se já existe um candidato com o mesmo nome, email ou telefone
        Optional<Candidato> existingCandidato = repository.findByNomeOrEmailOrTelefone(dto.getNome(), dto.getEmail(), dto.getTelefone());
        if (existingCandidato.isPresent()) {
            throw new RuntimeException("Já existe um candidato com o mesmo nome, email ou telefone.");
        }

        Candidato candidato = new Candidato();
        candidato.setNome(dto.getNome());
        candidato.setEmail(dto.getEmail());
        candidato.setSalarioPretendido(dto.getSalarioPretendido());
        candidato.setTelefone(dto.getTelefone());
        candidato.setVaga(dto.getVaga());
        candidato.setLinkedin(dto.getLinkedin());
        candidato.setGitHub(dto.getGitHub());
        candidato.setStatus(StatusCandidato.EM_ANALISE);
        Candidato savedCandidato = repository.save(candidato);
        
        // Logando o resultado no terminal
        logger.info("Candidato cadastrado: {}", savedCandidato);
        
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