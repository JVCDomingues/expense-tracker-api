package com.jvcdomingues.expenses.service;

import com.jvcdomingues.expenses.model.Produto;
import com.jvcdomingues.expenses.repository.ProdutoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> getProduto(Long id) throws Exception {
        Optional<Produto> produto = produtoRepository.findById(id);
        if(!produto.isPresent()) {
            ResponseEntity.notFound().build();
            throw new NotFoundException("Produto ID " + id + " não encontrado!");
        }

        return produto;
    }

    public List<Produto> getProdutosByCategoria(String categoria) throws Exception {
        List<Produto> produtoList = produtoRepository.findByCategoria(categoria);

        if(produtoList.isEmpty()) {
            throw new RuntimeException("Não há produtos com a categoria " + categoria);
        }

        return produtoRepository.findByCategoria(categoria);
    }

    public Produto addProduto(Produto produto) throws Exception {
        try {
            return produtoRepository.save(produto);
        }
        catch(Exception e) {
            throw new Exception(e);
        }
    }

    public ResponseEntity<Object> updateProduto(Produto novoProduto, Long id) throws Exception {
        Optional<Produto> produtoExists = produtoRepository.findById(id);

        if(!produtoExists.isPresent())
            throw new NotFoundException("Produto ID " + id + " não encontrado!");

        novoProduto.setId(id);
        produtoRepository.save(novoProduto);

        return ResponseEntity.noContent().build();
    }


    public ResponseEntity<Produto> deleteProduto(Long id) throws Exception {
        Optional<Produto> produto = produtoRepository.findById(id);

        if(!produto.isPresent()) {
            throw new NotFoundException("Produto ID " + id + " não encontrado");
        }

        produtoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
