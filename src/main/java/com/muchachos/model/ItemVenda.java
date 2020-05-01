package com.muchachos.model;

/**
 * 30/04/2020 22:05
 * @author Ramses
 */
public class ItemVenda {
    private Integer idItem;
    private Integer idVenda;
    private Float valorTotal;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }
    
    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
