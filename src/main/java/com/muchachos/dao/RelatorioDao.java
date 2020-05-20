package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Detalhes;
import com.muchachos.model.Relatorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 11/05/2020 15:58
 *
 * @author Fabio Vieira
 */
public class RelatorioDao {

    //RELATORIO DE VENDAS
    public List<Relatorio> getVendas(Timestamp dataDe, Timestamp dataPara, String filial, String cliente) throws SQLException, ClassNotFoundException {
        List<Relatorio> relatorio = null;
        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select v.id,c.nome as nome,v.dat,v.qtd_itens,v.val_total,f.nome as colaborador,f.filial as filial from tb_venda as v"
                    + " inner join tb_cliente as c on v.id_cliente = c.id "
                    + "inner join tb_colaborador as f on v.id_funcionario = f.id "
                    + "where (c.nome like ?) and (f.filial like ?) and (v.dat >= ? and v.dat<= ?)");

            ps.setString(1, cliente);
            ps.setString(2, filial);
            ps.setTimestamp(3, dataDe);
            ps.setTimestamp(4, dataPara);

            ResultSet rs = ps.executeQuery();
            relatorio = new ArrayList<>();

            while (rs.next()) {
                Relatorio r = new Relatorio(rs.getInt("id"), rs.getString("nome"), rs.getDate("dat"), rs.getInt("qtd_itens"),
                        rs.getFloat("val_total"), rs.getString("colaborador"), rs.getString("filial"));
                relatorio.add(r);
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());

        }
        return relatorio;
    }

    //DETALHE DE CADA VENDA
    public List<Detalhes> getDetalhes(int id, String categoria) throws SQLException, ClassNotFoundException {
        List<Detalhes> iv = new ArrayList<>();

        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select iv.Id_Produto, iv.Nome_Produto, iv.qtd_itens, p.Categoria, iv.val_Unitario, iv.val_total from tb_itensVenda as iv"
                    + " inner join tb_produto as p on iv.ID_PRODUTO = p.ID"
                    + " where iv.id_venda = ? and p.categoria like ?");

            ps.setInt(1, id);
            ps.setString(2, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                iv.add(new Detalhes(rs.getInt("id_produto"), rs.getString("nome_produto"), rs.getInt("qtd_itens"), rs.getString("categoria"), rs.getFloat("val_unitario"), rs.getFloat("val_total")));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());
        }
        return iv;
    }

}
