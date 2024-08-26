package com.example.LojaRoupas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LojaRoupas.entity.Produto;
import com.example.LojaRoupas.repository.ProdutoRepository;
import com.example.LojaRoupas.service.ProdutoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/Produto")
public class ControllerProduto {
    @Autowired
    private ProdutoService ProdutoService;
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Produto Produto) {
        try {
            String mensagemString = this.ProdutoService.save(Produto);
            return new ResponseEntity<>(mensagemString, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu esse ERRO ao tentar Salvar:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/listAll")
    public ResponseEntity<List<Produto>> listAll() {
        try {
            List<Produto> lista = this.ProdutoService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{idProduto}")
    public ResponseEntity<Produto> findById(@PathVariable long idProduto) {
        try {
            Produto Produto = this.ProdutoService.findById(idProduto);
            return new ResponseEntity<>(Produto, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{idProduto}")
    public ResponseEntity<String> delete(@PathVariable long idProduto) {
        try {
            String mensagem = this.ProdutoService.delete(idProduto);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu erro ao deletar", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{idProduto}")
    public ResponseEntity<String> update(@RequestBody Produto Produto, @PathVariable long idProduto) {
        try {
            String mensagem = this.ProdutoService.update(Produto, idProduto);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Deu esse erro ao salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar produtos pelo nome
    @SuppressWarnings("null")
    @GetMapping("/by-name")
    public ResponseEntity<List<Produto>> getByNome(@RequestParam String nome) {
        try {
            List<Produto> produtos = produtoRepository.findByNome(nome);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint para buscar produtos com valor maior ou igual a um determinado valor
    @SuppressWarnings("null")
    @GetMapping("/find-Great")
    public ResponseEntity<List<Produto>> findByValorGreaterThanEqual(@RequestParam double val) {
        try {
            List<Produto> produtos = produtoRepository.findByValorGreaterThanEqual(val);
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}