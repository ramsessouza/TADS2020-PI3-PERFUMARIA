package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import static com.muchachos.db.ConexaoDatabase.getConexao;
import com.muchachos.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Souza de Queiroz
 */
public class ProdutoDao {

    public List<Produto> getProduto() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nome, preco, quantidade, descricao, categoria, status From tb_produto";

        List<Produto> listaProdutos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaProdutos == null) {
                    listaProdutos = new ArrayList<Produto>();
                }
                Produto produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setNome(result.getString("nome"));
                produto.setPreco(result.getFloat("preco"));
                produto.setQuantidade(result.getInt("quantidade"));
                produto.setDescricao(result.getString("descricao"));
                produto.setCategoria(result.getString("categoria"));
                produto.setStatus(result.getString("status"));
                listaProdutos.add(produto);
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaProdutos;
    }

    public void salvar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement("insert into tb_produto (nome, preco, quantidade, descricao, categoria, status)" + "values(?,?,?,?,?,?)");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getStatus());
        statement.execute();
    }

    public List<Produto> getProduto1() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, preco, quantidade, categoria, status from tb_produto");

        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList();

        while (rs.next()) {
            while (rs.next()) {
                produtos.add(new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
            }
            return produtos;

        }
        return produtos;
    }

    public void excluir(Integer cod) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement("DELETE FROM tb_produto WHERE id = ?");

        statement.setInt(1, cod);
        statement.execute();
    }

    public Produto getProdutoId(Integer cod) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, preco,quantidade,descricao,categoria,status FROM tb_produto WHERE id=?");
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Produto(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getInt(4),
                    rs.getString(5), rs.getString(6), rs.getString(7));
        }

        throw new SQLException("Codigo não encontrado: " + cod);
    }

    public void atualizar(Produto produto) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " UPDATE tb_produto  SET nome=?, preco=?, quantidade=?, descricao=?, categoria=?, status=? WHERE id=?");

        statement.setString(1, produto.getNome());
        statement.setFloat(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setString(4, produto.getDescricao());
        statement.setString(5, produto.getCategoria());
        statement.setString(6, produto.getStatus());
        statement.setInt(7, produto.getId());
        statement.execute();
    }

    public static List<Produto> buscar(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM tb_produto WHERE upper(nome) like ? or upper(categoria) like ?";
        busca = busca + '%';

        List<Produto> listaProduto = null;
        Connection conexao = null;
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, busca.toUpperCase());
            ps.setString(2, busca.toUpperCase());

            rs = ps.executeQuery();

            while (rs.next()) {
                if (listaProduto == null) {
                    listaProduto = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
                String status = rs.getString("status");

                Produto P = new Produto(id, nome, preco, quantidade, categoria, status);
                listaProduto.add(P);
            }

        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e);
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaProduto;
    }

    public static List<Produto> buscarDireito(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM tb_produto WHERE status = 'ativo' and (upper(nome) like ? or upper(categoria) like ?)";
        busca = '%' + busca + '%';

        List<Produto> listaProduto = null;
        Connection conexao = null;
        PreparedStatement ps = null;

        ResultSet rs = null;

        try {
            conexao = ConexaoDatabase.getConexao();
            ps = conexao.prepareStatement(sql);
            ps.setString(1, busca.toUpperCase());
            ps.setString(2, busca.toUpperCase());

            rs = ps.executeQuery();

            while (rs.next()) {
                if (listaProduto == null) {
                    listaProduto = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                float preco = rs.getFloat("preco");
                int quantidade = rs.getInt("quantidade");
                String categoria = rs.getString("categoria");
                String status = rs.getString("status");

                Produto P = new Produto(id, nome, preco, quantidade, categoria, status);
                listaProduto.add(P);
            }

        } catch (SQLException e) {
            e.getMessage();
            System.out.println(e);
        } finally {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
            if (ps != null && !ps.isClosed()) {
                ps.close();
            }
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaProduto;
    }

}
