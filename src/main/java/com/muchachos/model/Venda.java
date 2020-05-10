package com.muchachos.model;

import java.sql.Date;

/**
 * 30/04/2020 22:03
 *
 * @author Fabio
 */
public class Venda {

    private int id;
    private int id_cliente;
    private Date data;
    private int qtd_itens;
    private float total;
    private float dinheiro;
    private float debito;
    private float credito;
    private String parcelas;
    private float desconto;
    private float troco;
    private String vend_resp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtd_itens() {
        return qtd_itens;
    }

    public void setQtd_itens(int qtd_itens) {
        this.qtd_itens = qtd_itens;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public float getDebito() {
        return debito;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public String getParcelas() {
        return parcelas;
    }

    public void setParcelas(String parcelas) {
        this.parcelas = parcelas;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }

    public String getVend_resp() {
        return vend_resp;
    }

    public void setVend_resp(String vend_resp) {
        this.vend_resp = vend_resp;
    }

    public Venda(int id_cliente, Date data, int qtd_itens, float total, float dinheiro, float debito, float credito, String parcelas, float desconto, float troco, String vend_resp) {
        this.id_cliente = id_cliente;
        this.data = data;
        this.qtd_itens = qtd_itens;
        this.total = total;
        this.dinheiro = dinheiro;
        this.debito = debito;
        this.credito = credito;
        this.parcelas = parcelas;
        this.desconto = desconto;
        this.troco = troco;
        this.vend_resp = vend_resp;
    }

    public Venda(int id, int id_cliente, Date data, int qtd_itens, float total, String vend_resp) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.data = data;
        this.qtd_itens = qtd_itens;
        this.total = total;
        this.vend_resp = vend_resp;
    }
}
