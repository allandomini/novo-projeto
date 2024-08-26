package com.example.LojaRoupas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.LojaRoupas.entity.Produto;
import com.example.LojaRoupas.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public String save(Produto Produto){
        this.produtoRepository.save(Produto);
        return Produto.getNome() + "salvo com sucesso";
    }
      public List<Produto> findAll() {
        return (List<Produto>) produtoRepository.findAll();
    }
        public Produto findById(long idProduto) {
        Produto Produto = this.produtoRepository.findById(idProduto).get();
        return Produto;

    }

    public String delete(long idProduto) {
        this.produtoRepository.deleteById(idProduto);
        return "Produto deletado com sucesso!";
    }

    public String update(Produto Produto, long idProduto) {
        Produto.setId(idProduto);
        this.produtoRepository.save(Produto);
        return Produto.getNome() + " salvo com sucesso";
    }


}
