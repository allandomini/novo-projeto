package com.example.LojaRoupas.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.LojaRoupas.entity.Produto;
import java.util.List;


public interface ProdutoRepository extends CrudRepository<Produto,Long>{
    @Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
    List<Produto> findByNome(String nome);
    List<Produto> findByValorGreaterThanEqual(double valor);
    
}
