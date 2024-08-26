package com.example.LojaRoupas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LojaRoupas.entity.Funcionario;
import com.example.LojaRoupas.service.FuncionarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/Funcionario")
public class ControllerFuncionario {
    @Autowired
    private FuncionarioService FuncionarioService;
    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Funcionario Funcionario) {
       try {
        String mensagemString = this.FuncionarioService.save(Funcionario);
        return new ResponseEntity<String>(mensagemString, HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>("Deu esse ERRO ao tentar Salvar:" + e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
      @SuppressWarnings("null")
    @GetMapping("/listAll")
    public ResponseEntity<List<Funcionario>> listAll() {
        try {
            List<Funcionario> lista = this.FuncionarioService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{idFuncionario}")
    public ResponseEntity<Funcionario> findById(@PathVariable long idFuncionario) {
        try {
            Funcionario Funcionario = this.FuncionarioService.findById(idFuncionario);
            return new ResponseEntity<>(Funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{idFuncionario}")
    public ResponseEntity<String> delete(@PathVariable long idFuncionario) {
        try { 
            String mensagem = this.FuncionarioService.delete(idFuncionario);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu erro ao deletar", HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{idFuncionario}")
    public ResponseEntity<String> update(@RequestBody Funcionario Funcionario, @PathVariable long idFuncionario) {
        try {
            String mensagem = this.FuncionarioService.update(Funcionario, idFuncionario);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu esse erro ao salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
