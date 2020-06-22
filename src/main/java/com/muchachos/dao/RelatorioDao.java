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
 * @author Fabio Vieira
 * 11/05/2020 15:58
 * @alter Ramses Souza
 * 19/06/2020 15:11
 */
public class RelatorioDao {

    //RELATORIO DE VENDAS
    public List<Relatorio> getVendas(Timestamp dataDe, Timestamp dataPara, 
            String filial, String cliente, String categoria, String cargo) 
            throws SQLException, ClassNotFoundException {
        String sql = "select distinct v.id,c.nome as nome,v.data,v.qtd_itens,"
                    + "v.val_total,f.nome as colaborador,f.filial as filial, "
                    + "v.val_troco as val_troco, v.pag_dinheiro as pag_dinheiro, "
                    + "v.pag_debito as pag_debito, v.pag_credito as pag_credito, "
                    + "v.parcelas as parcelas, v.val_desconto as val_desconto "
                    + "from tb_venda as v "
                    + " left join tb_cliente as c on v.id_cliente = c.id "
                    + " left join tb_colaborador as f on v.id_funcionario = f.id "
                    + " left join tb_itensvenda as iv on v.id = iv.id_venda "
                    + " left join tb_produto as p on iv.id_produto = p.id "
                    + " where (upper(c.nome) like ? or c.nome is null) and "
                    + "(f.filial like ?) and (p.categoria like ?) and "
                    + "(v.data >= ? and v.data<= ?) and (f.email <> 'admin@muchachos')";
        sql = (cliente.equals("%%")) ? sql : sql.replace("or c.nome is null", "");
        sql = (cargo.equals("administrador")) ? sql.replace(" and (f.email <> 'admin@muchachos')", "") : sql;
        List<Relatorio> listaRelatorio = null;
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            conexao = ConexaoDatabase.getConexao();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setString(1, cliente.toUpperCase());
            preparedStatement.setString(2, filial);
            preparedStatement.setString(3, categoria);
            preparedStatement.setTimestamp(4, dataDe);
            preparedStatement.setTimestamp(5, dataPara);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                if (listaRelatorio == null){
                    listaRelatorio = new ArrayList<Relatorio>();
                }
                Relatorio r = new Relatorio(
                    resultSet.getInt("id"), 
                    resultSet.getString("nome"), 
                    resultSet.getDate("data"), 
                    resultSet.getInt("qtd_itens"),
                    resultSet.getFloat("val_total"), 
                    resultSet.getString("colaborador"), 
                    resultSet.getString("filial"),
                    resultSet.getFloat("val_troco"),
                    resultSet.getFloat("pag_dinheiro"),
                    resultSet.getFloat("pag_debito"),
                    resultSet.getFloat("pag_credito"),
                    resultSet.getInt("parcelas"),
                    resultSet.getFloat("val_desconto")
                );
                listaRelatorio.add(r);
            }
        }finally{
            if(resultSet != null && !resultSet.isClosed()){
                resultSet.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaRelatorio;
    }

    //DETALHE DE CADA VENDA
    public List<Detalhes> getDetalhes(int id, String categoria) throws SQLException, ClassNotFoundException {
        String sql = "select iv.Id_Produto, p.Nome, iv.qtd_itens, p.Categoria, p.preco, iv.val_total from tb_itensVenda as iv"
                    + " inner join tb_produto as p on iv.ID_PRODUTO = p.ID"
                    + " where iv.id_venda = ? and p.categoria like ?";
        List<Detalhes> listaDetalhes = null;
        Connection conexao = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            conexao = ConexaoDatabase.getConexao();
            preparedStatement = conexao.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, categoria);
            
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                if (listaDetalhes == null){
                    listaDetalhes = new ArrayList<Detalhes>();
                }
                Detalhes detalheVenda = new Detalhes(
                    resultSet.getInt("id_produto"), 
                    resultSet.getString("nome"), 
                    resultSet.getInt("qtd_itens"), 
                    resultSet.getString("categoria"), 
                    resultSet.getFloat("preco"), 
                    resultSet.getFloat("val_total")
                );
                listaDetalhes.add(detalheVenda);
            }
        }finally{
            if(resultSet != null && !resultSet.isClosed()){
                resultSet.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaDetalhes;
    }

}
