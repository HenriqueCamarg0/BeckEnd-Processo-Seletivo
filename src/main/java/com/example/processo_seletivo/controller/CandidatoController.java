package com.example.processo_seletivo.controller;

import com.example.processo_seletivo.dto.CandidatoDTO;
import com.example.processo_seletivo.model.Candidato;
import com.example.processo_seletivo.service.CandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CandidatoController {
    private final CandidatoService service;

    @PostMapping("/cadastrar-candidato")
    public ResponseEntity<Candidato> cadastrar(@RequestBody @Valid CandidatoDTO dto) {
        Candidato candidato = service.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(candidato);
    }

    @GetMapping("/lista-de-candidatos")
    public ResponseEntity<List<Candidato>> listarTodos() {
        List<Candidato> candidatos = service.listarTodos();
        return ResponseEntity.ok(candidatos);
    }

    @GetMapping("/lista-de-candidato/{id}")
    public ResponseEntity<Candidato> listarPorId(@PathVariable Long id) {
        Candidato candidato = service.obterPorId(id);
        return ResponseEntity.ok(candidato);
    }

    @DeleteMapping("/candidatos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
