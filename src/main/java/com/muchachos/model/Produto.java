package com.muchachos.model;

/**
 *
 * @author Diego Souza
 */
public class Produto {
    private String nome;        
    private float preco;        
    private int quantidade;
    private String descricao;
    private String categoria;
    private boolean status;

    public Produto(String nome, String preco, String quantidade, String descricao, String categoria, String status) {
        this.setNome(nome);
        this.setPreco (Float.parseFloat(preco));
        this.setQuantidade(Integer.parseInt(quantidade));
        this.setDescricao(descricao);
        this.setCategoria (categoria);
        this.setStatus (Boolean.getBoolean(status));
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
