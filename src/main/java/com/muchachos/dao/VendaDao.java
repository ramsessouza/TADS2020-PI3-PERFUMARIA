package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 30/04/2020 22:08
 *
 * @author Fabio
 */
public class VendaDao {

    public List<Venda> getVendas() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select v.id,c.id_cliente,v.data,v.qtd_itens,v.val_total,f.vend_resp from TB_VENDA as v"
                + "join cliente as c on v.id_cliente=c.id"
                + "join funcionario as f on v.vend_resp=f.id"
                + "where data between ? and ? and filial = ?");
        ResultSet rs = ps.executeQuery();
        List<Venda> vendas = new ArrayList<>();
        while (rs.next()) {
            vendas.add(new Venda(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getFloat(5), rs.getString(6)));
        }
        return vendas;
    }

    public void salvarVenda(Venda venda) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
		" insert into TB_VENDA(id_cliente, data, qtd_itens, val_total, pag_dinheiro,pag_debito, pag_credito, parcelas, desconto,"
		+ " troco,vend_resp");

        statement.setInt(1, venda.getId_cliente());
        statement.setDate(2, venda.getData());
        statement.setInt(3, venda.getQtd_itens());
        statement.setFloat(4, venda.getTotal());
        statement.setFloat(5, venda.getDinheiro());
        statement.setFloat(6, venda.getDebito());
        statement.setFloat(7, venda.getCredito());
        statement.setString(8, venda.getParcelas());
        statement.setFloat(9, venda.getDesconto());
        statement.setFloat(10, venda.getTroco());
        statement.setString(11, venda.getVend_resp());
        
        statement.execute();
    }
}
