package com.muchachos.model;

/**
 * 11/05/2020 15:48
 * @author Fabio
 */
public class Detalhes {
    int id_produto;
    String nome_produto;
    int qtd_itens;
    String categoria;
    float valor_uni;
    float valor_item;

    public Detalhes(int id_produto, String nome_produto, int qtd, String categoria, float valor_uni, float valor_item) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.qtd_itens = qtd;
        this.categoria = categoria;
        this.valor_uni = valor_uni;
        this.valor_item = valor_item;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQtd() {
        return qtd_itens;
    }

    public void setQtd(int qtd) {
        this.qtd_itens = qtd;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getValor_uni() {
        return valor_uni;
    }

    public void setValor_uni(float valor_uni) {
        this.valor_uni = valor_uni;
    }

    public float getValor_item() {
        return valor_item;
    }

    public void setValor_item(float valor_item) {
        this.valor_item = valor_item;
    }
     
   
}
