package com.example.processo_seletivo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class CandidatoDTO {
    @NotNull
    private String nome;

    @Email
    private String email;
}