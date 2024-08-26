package com.example.LojaRoupas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LojaRoupas.entity.Venda;
import com.example.LojaRoupas.service.VendaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/Venda")
public class ControllerVenda {
    @Autowired
    private VendaService VendaService;
    @PostMapping("/save")
    public ResponseEntity<String> save (@RequestBody Venda Venda) {
       try {
        String mensagemString = this.VendaService.save(Venda);
        return new ResponseEntity<String>(mensagemString, HttpStatus.OK);
       } catch (Exception e) {
        return new ResponseEntity<>("Deu esse ERRO ao tentar Salvar:" + e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }
      @SuppressWarnings("null")
    @GetMapping("/listAll")
    public ResponseEntity<List<Venda>> listAll() {
        try {
            List<Venda> lista = this.VendaService.findAll();
            return new ResponseEntity<>(lista, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @SuppressWarnings("null")
    @GetMapping("/findById/{idVenda}")
    public ResponseEntity<Venda> findById(@PathVariable long idVenda) {
        try {
            Venda Venda = this.VendaService.findById(idVenda);
            return new ResponseEntity<>(Venda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        }
    }

    @DeleteMapping("/delete/{idVenda}")
    public ResponseEntity<String> delete(@PathVariable long idVenda) {
        try {
            String mensagem = this.VendaService.delete(idVenda);
            return new ResponseEntity<>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu erro ao deletar", HttpStatus.BAD_REQUEST);

        }
    }

    @PutMapping("/update/{idVenda}")
    public ResponseEntity<String> update(@RequestBody Venda Venda, @PathVariable long idVenda) {
        try {
            String mensagem = this.VendaService.update(Venda, idVenda);
            return new ResponseEntity<String>(mensagem, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Deu esse erro ao salvar: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    

}
