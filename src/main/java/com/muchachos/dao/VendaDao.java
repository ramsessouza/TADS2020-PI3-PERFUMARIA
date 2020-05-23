package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * 
 * 30/04/2020 22:08
 * @author Ramses
 */
public class VendaDao {
    public static void salvar(Venda venda) throws ClassNotFoundException, SQLException {
        
        String sql = "INSERT INTO TB_VENDA(id_cliente, id_funcionario, data,"
                + " qtd_Itens, val_total, pag_dinheiro, pag_debito, pag_credito,"
                + " parcelas, val_desconto, val_troco) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = ConexaoDatabase.getConexao();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, venda.getCliente().getId());
            preparedStatement.setInt(2, venda.getFuncionario().getId());
            java.sql.Timestamp data = new java.sql.Timestamp(venda.getData().getTime());
            preparedStatement.setTimestamp(3, data);
            preparedStatement.setInt(4, venda.getQtdItens());
            preparedStatement.setFloat(5, venda.getSubtotal());
            preparedStatement.setFloat(6, venda.getPagDinheiro());
            preparedStatement.setFloat(7, venda.getPagDebito());
            preparedStatement.setFloat(8, venda.getPagCredito());
            preparedStatement.setInt(9, venda.getParcelamento());
            preparedStatement.setFloat(10, venda.getDesconto());
            preparedStatement.setFloat(11, venda.getTroco());
            preparedStatement.execute();
        } finally {
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public static Integer obterUltima() throws ClassNotFoundException, SQLException {
        
        String sql = "SELECT MAX(ID) qtdVendas FROM TB_VENDA";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = ConexaoDatabase.getConexao();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            
            if(result.next()){
                Integer qtdVendas = result.getInt("qtdVendas");
                
                return qtdVendas;
            }
        }finally{
            if(result != null && !result.isClosed()){
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return null;
    }
}
