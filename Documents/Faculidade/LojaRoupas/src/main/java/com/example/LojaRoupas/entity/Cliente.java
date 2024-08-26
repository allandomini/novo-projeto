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
@Table(name = "cliente")
@Getter
@Setter
public class Cliente {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O nome do cliente é obrigatório")
    private String nome;

    @NotNull(message = "O CPF do cliente é obrigatório")
    private String cpf;

    @NotNull(message = "A idade do cliente é obrigatória")
    @Min(value = 18, message = "A idade mínima é 18 anos")
    private int idade;

    @NotNull(message = "O telefone do cliente é obrigatório")
    private String telefone;
   @OneToMany
   @JsonIgnoreProperties("cliente")
    private List<Venda> vendas;
}
