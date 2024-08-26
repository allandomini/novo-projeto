package com.example.LojaRoupas.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.LojaRoupas.entity.Cliente;
import com.example.LojaRoupas.repository.ClienteRepository;
import com.example.LojaRoupas.service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/cliente")
public class ControllerCliente {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Cliente cliente) {
        try {
            String mensagem = this.clienteService.save(cliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao tentar salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/listAll")
    public ResponseEntity<List<Cliente>> findAll() {
        try {
            List<Cliente> lista = this.clienteService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{idCliente}")
    public ResponseEntity<Cliente> findById(@PathVariable long idCliente) {
        try {
            Cliente cliente = this.clienteService.findById(idCliente);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idCliente}")
    public ResponseEntity<String> delete(@PathVariable long idCliente) {
        try {
            String mensagem = this.clienteService.delete(idCliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{idCliente}")
    public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long idCliente) {
        try {
            String mensagem = this.clienteService.update(cliente, idCliente);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao atualizar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @SuppressWarnings("null")
    @GetMapping("/by-cpf")
    public ResponseEntity<Cliente> getByCpf(@RequestParam String cpf) {
        try {
            Cliente cliente = clienteRepository.findByCpf(cpf);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/by-name")
    public ResponseEntity<List<Cliente>> getByNome(@RequestParam String nome) {
        try {
            List<Cliente> clientes = clienteRepository.findByNome(nome);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/find-Great")
    public ResponseEntity<List<Cliente>> findByIdadeGreaterThanEqual(@RequestParam int idade) {
        try {
            List<Cliente> clientes = clienteRepository.findByIdadeGreaterThanEqual(idade);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}