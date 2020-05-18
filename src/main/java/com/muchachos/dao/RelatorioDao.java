package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Produto;
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
 * @author Fabio
 */
public class RelatorioDao {

    public List<Relatorio> getVendas(Timestamp dataDe, Timestamp dataPara, String filial, String cliente) throws SQLException, ClassNotFoundException {
        List<Relatorio> relatorio = null;
        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select v.id,c.nome as nome,v.dat,v.qtd_itens,v.val_total,f.nome as colaborador,f.filial as filial from tb_venda as v"
                    + " inner join tb_cliente as c on v.id_cliente = c.id "
                    + "inner join tb_colaborador as f on v.id_funcionario = f.id "
                    + "where (c.nome like ? or f.filial = ?) and (v.dat >= ? and v.dat<= ?)");

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

    public List<Produto> getDetalhes(String id) throws SQLException, ClassNotFoundException {
        List<Produto> iv = new ArrayList<>();

        try {
            Connection conexao = ConexaoDatabase.getConexao();

            PreparedStatement ps = conexao.prepareStatement("select Id_Produto, Nome_Produto, qtd_itens, Categoria, val_Unitário, val_total from tb_itensVenda where id_venda = ?");

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            //iv.add(new ItensVenda(rs.getInt(0),rs.getString(1), rs.getInt(2), rs.getString(3),rs.getFloat(4),rs.getFloat(5)));
            }
            }catch (SQLException sQLException) {
            System.out.println(sQLException.toString());
        }catch (Exception sQLException) {
            System.out.println(sQLException.toString());
        }
            return iv;
        }

    }
