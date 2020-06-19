
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
    private Float troco;
    private Float pag_deb;
    private Float pag_din;
    private Float pag_cred;
    private int parcelas;
    private Float val_desc;

    public Float getPag_deb() {
        return pag_deb;
    }

    public void setPag_deb(Float pag_deb) {
        this.pag_deb = pag_deb;
    }

    public Float getPag_din() {
        return pag_din;
    }

    public void setPag_din(Float pag_din) {
        this.pag_din = pag_din;
    }

    public Float getPag_cred() {
        return pag_cred;
    }

    public void setPag_cred(Float pag_cred) {
        this.pag_cred = pag_cred;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Float getVal_desc() {
        return val_desc;
    }

    public void setVal_desc(Float val_desc) {
        this.val_desc = val_desc;
    }

    public Float getTroco() {
        return troco;
    }

    public void setTroco(Float troco) {
        this.troco = troco;
    }
    
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

    public Relatorio(int id, String cliente, Date date, int qtd_itens, float total, 
            String vend_resp, String filial, Float troco, Float pag_deb, Float pag_din,
            Float pag_cred, int parcelas, Float val_desc) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String c = sdf.format(date);
        
        this.id = id;
        this.cliente = cliente;
        this.data = c;
        this.qtd_itens = qtd_itens;
        this.total = total;
        this.vend_resp = vend_resp;
        this.filial = filial;
        this.troco = troco;
        this.pag_deb = pag_deb;
        this.pag_din = pag_din;
        this.pag_cred = pag_cred;
        this.parcelas = parcelas;
        this.val_desc = val_desc;
    }
}