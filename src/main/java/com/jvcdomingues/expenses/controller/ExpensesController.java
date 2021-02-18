package com.jvcdomingues.expenses.controller;

import com.jvcdomingues.expenses.model.Produto;
import com.jvcdomingues.expenses.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ExpensesController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/produtos")
    public List<Produto> getProdutos() {
        return produtoService.getProdutos();
    }

    @GetMapping("/produto/{id}")
    public Optional<Produto> getProduto(@PathVariable Long id) throws Exception {
        return produtoService.getProduto(id);
    }

    @GetMapping("/produtos/categoria")
    public List<Produto> getProdutosByCategoria(@RequestParam String categoria) throws Exception {
        return produtoService.getProdutosByCategoria(categoria);
    }

    @PostMapping("/produtos")
    public Produto addProduto(@RequestBody Produto produto) throws Exception {
        return produtoService.addProduto(produto);
    }

    @PutMapping("/produto/{id}")
    public ResponseEntity<Object> updateProduto(@RequestBody Produto produto, @PathVariable Long id) throws Exception {
        return produtoService.updateProduto(produto, id);
    }

    @DeleteMapping("/produto/{id}")
    public ResponseEntity<Produto> removeProduto(@PathVariable Long id) throws Exception {
        return produtoService.deleteProduto(id);
    }
}
