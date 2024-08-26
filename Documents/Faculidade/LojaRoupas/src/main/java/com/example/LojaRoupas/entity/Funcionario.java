package com.example.LojaRoupas.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "funcionario")
@Getter
@Setter
public class Funcionario {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O nome do funcionário é obrigatório")
    private String nome;

    @NotNull(message = "A idade do funcionário é obrigatória")
    @Min(value = 18, message = "A idade mínima é 18 anos")
    private int idade;

    @NotNull(message = "A matrícula do funcionário é obrigatória")
    private String matricula;

    @OneToMany(mappedBy = "funcionario")
    @JsonIgnoreProperties("funcionario")  // Evita a repetição
    private List<Venda> vendas;
}
