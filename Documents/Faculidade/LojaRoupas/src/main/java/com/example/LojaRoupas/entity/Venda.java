package com.example.LojaRoupas.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.util.List;



@Entity
@Table(name = "venda")
@Getter
@Setter
public class Venda {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enderecoEntrega; 
    
    private double valorTotal;

    @ManyToMany(cascade = CascadeType.ALL) 
    @JoinTable(name = "venda_produto",
               joinColumns = @JoinColumn(name = "venda_id"),
               inverseJoinColumns = @JoinColumn(name = "produto_id"))
    private List<Produto> produtos;

    @ManyToOne(cascade = CascadeType.ALL)  
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    @ManyToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;
}