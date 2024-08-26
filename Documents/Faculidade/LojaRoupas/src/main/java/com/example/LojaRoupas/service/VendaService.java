package com.example.LojaRoupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LojaRoupas.entity.Venda;
import com.example.LojaRoupas.repository.VendaRepository;

@Service
public class VendaService {
    @Autowired
    private VendaRepository VendaRepository;

    public String save(Venda Venda){
        this.VendaRepository.save(Venda);
        return Venda.getId() + "salvo com sucesso";
    }
      public List<Venda> findAll() {
        return (List<Venda>) VendaRepository.findAll();
    }
        public Venda findById(long idVenda) {
        Venda Venda = this.VendaRepository.findById(idVenda).get();
        return Venda;

    }

    public String delete(long idVenda) {
        this.VendaRepository.deleteById(idVenda);
        return "Venda deletado com sucesso!";
    }

    public String update(Venda Venda, long idVenda) {
        Venda.setId(idVenda);
        this.VendaRepository.save(Venda);
        return Venda.getId() + " salvo com sucesso";
    }


}
