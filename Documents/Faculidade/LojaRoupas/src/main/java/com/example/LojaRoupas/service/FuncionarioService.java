package com.example.LojaRoupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LojaRoupas.entity.Funcionario;
import com.example.LojaRoupas.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;
  public String save(Funcionario Funcionario){
        this.funcionarioRepository.save(Funcionario);
        return Funcionario.getNome() + " salvo com sucesso"; 
    }

    public List<Funcionario> findAll() {
        return (List<Funcionario>) funcionarioRepository.findAll();
    }
        public Funcionario findById(long idFuncionario) {
        Funcionario Funcionario = this.funcionarioRepository.findById(idFuncionario).get();
        return Funcionario;

    }

    public String delete(long idFuncionario) {
        this.funcionarioRepository.deleteById(idFuncionario);
        return "Funcionario deletado com sucesso!";
    }

    public String update(Funcionario Funcionario, long idFuncionario) {
        Funcionario.setId(idFuncionario);
        this.funcionarioRepository.save(Funcionario);
        return Funcionario.getNome() + " salvo com sucesso";
    }
}
