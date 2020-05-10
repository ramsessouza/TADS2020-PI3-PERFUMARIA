package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Diego Souza de Queiroz
 */
public class ProdutoDao {

    public static boolean cadastrarProduto(Produto produto) {
        boolean ok = false;
        Connection con;
        try {
            con = ConexaoDatabase.getConexao();
            String sql = "insert into TB_PRODUTO values (default,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getCategoria());
            ps.setInt(3, produto.getQuantidade());
            ps.setFloat(4, produto.getPreco());
            ps.setBoolean(5, produto.getStatus());
            ps.setString(6, produto.getDescricao());
            ps.execute();
            ok = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }
}
