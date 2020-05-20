
package com.muchachos.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 11/05/2020 16:00
 *
 * @author Fabio
 */
public class Relatorio {

    private int id;
    private String cliente;
    private String data;
    private int qtd_itens;
    private float total;
    private String vend_resp;
    private String filial;

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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

    public String getVend_resp() {
        return vend_resp;
    }

    public void setVend_resp(String vend_resp) {
        this.vend_resp = vend_resp;
    }

    public Relatorio(int id, String cliente, Date date, int qtd_itens, float total, String vend_resp, String filial) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String c = sdf.format(date);
        
        this.id = id;
        this.cliente = cliente;
        this.data = c;
        this.qtd_itens = qtd_itens;
        this.total = total;
        this.vend_resp = vend_resp;
        this.filial = filial;
    }
}

