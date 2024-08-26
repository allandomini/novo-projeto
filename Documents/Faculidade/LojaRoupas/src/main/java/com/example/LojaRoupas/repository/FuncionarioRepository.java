package com.example.LojaRoupas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.LojaRoupas.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    
    @Query("SELECT f FROM Funcionario f WHERE f.idade >= :idade")
    List<Funcionario> findByIdadeGreaterThanEqual(@Param("idade") int idade);

    List<Funcionario> findByMatricula(String matricula);
    List<Funcionario> findByNomeContaining(String substring);

}