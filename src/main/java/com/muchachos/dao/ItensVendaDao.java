package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.ItemVenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 30/04/2020 22:11
 * @author Ramses
 */
public class ItensVendaDao {
    public static void salvar(ItemVenda itemVenda)throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO TB_ITENSVENDA(id_venda, id_produto, "
                + "qtd_itens, val_total) "
                + "VALUES(?, ?, ?, ?)";

            Connection connection = null;
            PreparedStatement preparedStatement = null;

            try {

            connection = ConexaoDatabase.getConexao();

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, itemVenda.getIdVenda());
            preparedStatement.setInt(2, itemVenda.getId());
            preparedStatement.setInt(3, itemVenda.getQtdItens());
            preparedStatement.setFloat(4, itemVenda.getValorTotal());

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
}