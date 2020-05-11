package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 11/05/2020 15:58
 *
 * @author Fabio
 */
public class RelatorioDao {

    public List<Relatorio> getVendas() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("select v.id,c.NOME,v.data,v.qtd_itens,v.val_total,f.NOME from TB_VENDA as v"
                + "join cliente as c on v.id_cliente=c.id"
                + "join funcionario as f on v.vend_resp=f.id"
                + "where data between ? and ? and filial = ?");
        ResultSet rs = ps.executeQuery();
        List<Relatorio> relatorio = new ArrayList<>();
        while (rs.next()) {
            relatorio.add(new Relatorio(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getInt(4), rs.getFloat(5), rs.getString(6)));
        }
        return relatorio;
    }
}
