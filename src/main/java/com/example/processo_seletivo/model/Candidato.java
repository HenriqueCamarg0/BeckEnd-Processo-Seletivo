package com.example.processo_seletivo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome não pode ser nulo")
    private String nome;

    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Positive(message = "O salário pretendido deve ser positivo")
    private Double salarioPretendido;

    private StatusCandidato status;
}
