package com.jvcdomingues.expenses.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    @Column(name="data_compra")
    private String dataCompra;

    @NotNull
    private String categoria;

    public Produto() {}

    public Produto(long id, String nome, BigDecimal preco, String dataCompra, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.dataCompra = dataCompra;
        this.categoria = categoria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }
}
