package com.muchachos.model;

/**
 * 30/04/2020 22:05
 * @author Ramses
 * Atualizado 18/05/2020 19:44
 * @author Ramses
 */
public class ItemVenda extends Produto{
    private Integer id;
    private Integer idVenda;
    private Integer qtdItens;
    private Float valorTotal;

    public ItemVenda() {
        
    }
    
    public ItemVenda(Integer id, Integer idProduto, Integer idVenda, Integer qtdItens, Float valorTotal) {
        this.id = id;
        this.idVenda = idVenda;
        this.qtdItens = qtdItens;
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
