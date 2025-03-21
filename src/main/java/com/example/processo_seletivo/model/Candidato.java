package com.example.processo_seletivo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(uniqueConstraints ={
    @UniqueConstraint(columnNames = "nome"), // Restrição de unicidade
    @UniqueConstraint(columnNames = "email"), // Restrição de unicidade
    @UniqueConstraint(columnNames = "telefone") // Restrição de unicidade
})
public class Candidato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =200, nullable = false)
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode estar em branco")
    private String nome;

    @Column(length =200, nullable = false)
    @Email(message = "O email deve ser válido")
    @NotNull(message = "O email não pode ser nulo")
    private String email;

    @Column(length =200, nullable = false)
    @NotNull(message = "O salário pretendido não pode ser nulo")
    @Positive(message = "O salário pretendido deve ser positivo")
    private Double salarioPretendido;

    @Column(length = 15, nullable = false) 
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
    @Enumerated(EnumType.STRING)
    private Vaga vaga;

    private StatusCandidato status = StatusCandidato.EM_ANALISE;
}
