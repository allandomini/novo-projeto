package com.example.LojaRoupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.LojaRoupas.entity.Cliente;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente findByCpf(@Param("cpf") String cpf);
    List<Cliente> findByNome(String nome);
    List<Cliente> findByIdadeGreaterThanEqual(int idade);
}