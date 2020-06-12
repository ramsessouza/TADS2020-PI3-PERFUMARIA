package com.muchachos.dao;

/**
 *
 * @author Valter Lafuente Junior
 */
import com.muchachos.db.ConexaoDatabase;
import static com.muchachos.db.ConexaoDatabase.getConexao;
import com.muchachos.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {

    public List<Funcionario> getFuncionario() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nome, Cpf, Rg, Sexo, estado_civil, nascimento, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
                + "Email,status, Senha, Cargo, Filial, Departamento FROM TB_COLABORADOR";

        List<Funcionario> listaFuncionarios = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();

            while (result.next()) {
                if (listaFuncionarios == null) {
                    listaFuncionarios = new ArrayList<Funcionario>();
                }
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setDataNascimento(result.getString("nascimento"));
                funcionario.setEstadoCivil(result.getString("estado_civil"));
                funcionario.setStatus(result.getString("status"));
                funcionario.setRg(result.getString("rg"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setFilial(result.getString("filial"));
                funcionario.setDepartamento(result.getString("departamento"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setBairro(result.getString("bairro"));
                funcionario.setLogradouro(result.getString("logradouro"));
                funcionario.setNumero(result.getInt("numero"));
                funcionario.setComplemento(result.getString("complemento"));

                listaFuncionarios.add(funcionario);
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
        return listaFuncionarios;
    }

    public void salvar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " insert into TB_COLABORADOR(nome,sexo, nascimento, estado_civil, status, rg,cpf , telefone, email, senha, "
                + " filial,departamento,cargo,estado,cidade, bairro, logradouro,numero,complemento)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getSexo());
        statement.setString(3, funcionario.getDataNascimento());
        statement.setString(4, funcionario.getEstadoCivil());
        statement.setString(5, funcionario.getStatus());
        statement.setString(6, funcionario.getRg());
        statement.setString(7, funcionario.getCpf());
        statement.setString(8, funcionario.getTelefone());
        statement.setString(9, funcionario.getEmail());
        statement.setString(10, funcionario.getSenha());
        statement.setString(11, funcionario.getFilial());
        statement.setString(12, funcionario.getDepartamento());
        statement.setString(13, funcionario.getCargo());
        statement.setString(14, funcionario.getEstado());
        statement.setString(15, funcionario.getCidade());
        statement.setString(16, funcionario.getBairro());
        statement.setString(17, funcionario.getLogradouro());
        statement.setInt(18, funcionario.getNumero());
        statement.setString(19, funcionario.getComplemento());
        statement.execute();
    }

    public List<Funcionario> getFuncionario1() throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("Select cargo, filial, departamento, id, nome,cpf ,email, status from TB_COLABORADOR");

        ResultSet rs = ps.executeQuery();
        List<Funcionario> funcionarios = new ArrayList<>();

        while (rs.next()) {
            funcionarios.add(new Funcionario(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)));
        }

        return funcionarios;

    }

    public void excluir(Integer cod) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                "DELETE FROM TB_COLABORADOR WHERE id = ?");

        statement.setInt(1, cod);
        statement.execute();
    }

    public Funcionario getFuncionarioId(Integer cod) throws SQLException, ClassNotFoundException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, Cpf, Rg, Sexo,"
                + " estado_civil , nascimento, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
                + "Email,status , Senha, Cargo, Filial, Departamento FROM TB_COLABORADOR WHERE id=?");
        ps.setInt(1, cod);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                    rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
                    rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19), rs.getString(20));
        }
        throw new SQLException("Codigo não encontrado: " + cod);
    }

    public void atualizar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
        Connection conexao = ConexaoDatabase.getConexao();
        PreparedStatement statement = conexao.prepareStatement(
                " UPDATE TB_COLABORADOR SET nome=?, cpf=?, rg=?, sexo=?, estado_civil=?, nascimento=?, estado=?, cidade=?, bairro=?,  logradouro=?,"
                + " numero=?,complemento=?, telefone=?,email=?,status=?, senha=?, cargo=?, filial=?, departamento=? WHERE id=?");

        statement.setString(1, funcionario.getNome());
        statement.setString(2, funcionario.getCpf());
        statement.setString(3, funcionario.getRg());
        statement.setString(4, funcionario.getSexo());
        statement.setString(5, funcionario.getEstadoCivil());
        statement.setString(6, funcionario.getDataNascimento());
        statement.setString(7, funcionario.getEstado());
        statement.setString(8, funcionario.getCidade());
        statement.setString(9, funcionario.getBairro());
        statement.setString(10, funcionario.getLogradouro());
        statement.setInt(11, funcionario.getNumero());
        statement.setString(12, funcionario.getComplemento());
        statement.setString(13, funcionario.getTelefone());
        statement.setString(14, funcionario.getEmail());
        statement.setString(15, funcionario.getStatus());
        statement.setString(16, funcionario.getSenha());
        statement.setString(17, funcionario.getCargo());
        statement.setString(18, funcionario.getFilial());
        statement.setString(19, funcionario.getDepartamento());
        statement.setInt(20, funcionario.getId());
        statement.execute();

    }

    public static List<Funcionario> buscar(String busca) throws SQLException, Exception {
        String sql = "SELECT * FROM TB_COLABORADOR WHERE  upper(nome) like ? or upper(cpf) like ?";
        busca = busca + '%';

        List<Funcionario> listaFuncionario = null;

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
                if (listaFuncionario == null) {
                    listaFuncionario = new ArrayList<>();
                }
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String cargo = rs.getString("cargo");
                String filial = rs.getString("filial");
                String departamento = rs.getString("departamento");
                String status = rs.getString("status");
                Funcionario F = new Funcionario(cargo, filial, departamento, id, nome, cpf, email, status);
                listaFuncionario.add(F);
            }

        } catch (Exception e) {
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
        return listaFuncionario;
    }

    public static Funcionario obterFuncionarioEmail(String email) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nome, Cpf, Rg, Sexo,"
                + " estado_civil , nascimento, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
                + "Email,status , Senha, Cargo, Filial, Departamento FROM TB_COLABORADOR WHERE email=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;

        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, email);
            result = preparedStatement.executeQuery();

            if (result.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(result.getInt("id"));
                funcionario.setNome(result.getString("nome"));
                funcionario.setSexo(result.getString("sexo"));
                funcionario.setDataNascimento(result.getString("Nascimento"));
                funcionario.setEstadoCivil(result.getString("estado_civil"));
                funcionario.setStatus(result.getString("status"));
                funcionario.setRg(result.getString("rg"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setTelefone(result.getString("telefone"));
                funcionario.setEmail(result.getString("email"));
                funcionario.setSenha(result.getString("senha"));
                funcionario.setFilial(result.getString("filial"));
                funcionario.setDepartamento(result.getString("departamento"));
                funcionario.setCargo(result.getString("cargo"));
                funcionario.setEstado(result.getString("estado"));
                funcionario.setCidade(result.getString("cidade"));
                funcionario.setBairro(result.getString("bairro"));
                funcionario.setLogradouro(result.getString("logradouro"));
                funcionario.setNumero(result.getInt("numero"));
                funcionario.setComplemento(result.getString("complemento"));

                return funcionario;
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
        return null;
    }

}
