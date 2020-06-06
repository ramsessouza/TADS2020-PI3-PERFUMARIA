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
    public List<Relatorio> getVendas(Timestamp dataDe, Timestamp dataPara, String filial, String cliente, String categoria) throws SQLException, ClassNotFoundException {
        List<Relatorio> relatorio = null;
        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select distinct v.id,c.nome as nome,v.data,v.qtd_itens,v.val_total,f.nome as colaborador,f.filial as filial from tb_venda as v "
                    + " inner join tb_cliente as c on v.id_cliente = c.id "
                    + " inner join tb_colaborador as f on v.id_funcionario = f.id "
                    + " inner join tb_itensvenda as iv on v.id = iv.id_venda "
                    + " inner join tb_produto as p on iv.id_produto = p.id "
                    + " where (c.nome like ?) and (f.filial like ?) and (p.categoria like ?) and (v.data >= ? and v.data<= ?)");

            ps.setString(1, cliente);
            ps.setString(2, filial);
            ps.setString(3, categoria);
            ps.setTimestamp(4, dataDe);
            ps.setTimestamp(5, dataPara);

            ResultSet rs = ps.executeQuery();
            relatorio = new ArrayList<>();

            while (rs.next()) {
                Relatorio r = new Relatorio(rs.getInt("id"), rs.getString("nome"), rs.getDate("data"), rs.getInt("qtd_itens"),
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

            PreparedStatement ps = conexao.prepareStatement("select iv.Id_Produto, p.Nome, iv.qtd_itens, p.Categoria, p.preco, iv.val_total from tb_itensVenda as iv"
                    + " inner join tb_produto as p on iv.ID_PRODUTO = p.ID"
                    + " where iv.id_venda = ? and p.categoria like ?");

            ps.setInt(1, id);
            ps.setString(2, categoria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                iv.add(new Detalhes(rs.getInt("id_produto"), rs.getString("nome"), rs.getInt("qtd_itens"), rs.getString("categoria"), rs.getFloat("preco"), rs.getFloat("val_total")));
            }
        } catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        } catch (Exception sQLException) {
            System.out.println(sQLException.toString());
        }
        return iv;
    }

}
