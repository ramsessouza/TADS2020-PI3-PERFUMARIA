package com.muchachos.model;

/**
 *
 * @author Diego Souza
 */
public class Produto {

    private Integer id;
    private String nome;
    protected Float preco;
    private Integer quantidade;
    private String descricao;
    private String categoria;
    private String status;
    protected Integer qtdItem;

    public Produto() {

    }

    public Produto(Integer id) {
        this.id = id;
    }

    public Produto(Integer id, String nome, Float preco, Integer quantidade, String descricao, String categoria, String status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.categoria = categoria;
        this.status = status;
    }

    public Produto(Integer id, String nome, Float preco, Integer quantidade, String categoria, String status) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.status = status;
    }

    public Produto(Integer id, String nome, Float preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }
    
}
