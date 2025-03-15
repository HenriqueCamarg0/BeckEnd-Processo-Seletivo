package com.example.processo_seletivo.dto;

import com.example.processo_seletivo.model.Vaga;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;


@Data
public class CandidatoDTO {
    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @NotNull(message = "O salário pretendido não pode ser nulo")
    @Positive(message = "O salário pretendido deve ser positivo")
    private Double salarioPretendido;

    @NotNull(message = "O telefone não pode ser nulo")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @NotNull(message = "O LinkedIn não pode ser nulo")
    @Pattern(regexp = "https://www\\.linkedin\\.com/.*", message = "O LinkedIn deve ser uma URL válida")
    private String linkedin;

    @NotNull(message = "O GitHub não pode ser nulo")
    @Pattern(regexp = "https://github\\.com/.*", message = "O GitHub deve ser uma URL válida")
    private String gitHub;

    @NotNull(message = "A vaga desejada não pode ser nula")
    private Vaga vaga;
}