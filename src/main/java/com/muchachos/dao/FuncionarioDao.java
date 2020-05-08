package com.muchachos.dao;

/**
 *
 * @author Valter Lafuente Junior
 */
import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class FuncionarioDao {

	public List<Funcionario> getFuncionario() throws SQLException, ClassNotFoundException {

		Connection conexao = ConexaoDatabase.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, Cpf, Rg, Sexo,"
		+ " ESTADO_CIVIL, NASCIMENTO, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
		+ "Email,status, Senha, Cargo, Filial, Departamento FROM TB_COLABORADOR");

		ResultSet rs = ps.executeQuery();
		List<Funcionario> funcionarios = new ArrayList<>(); 
		while (rs.next()) {
		funcionarios.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
	        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
	        rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
	        rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),rs.getString(20)));
		}

		return funcionarios;
	} 
	     

	public void salvar(Funcionario funcionario) throws ClassNotFoundException, SQLException {
		Connection conexao = ConexaoDatabase.getConexao();
		PreparedStatement statement = conexao.prepareStatement(
		" insert into TB_COLABORADOR(NOME,SEXO, NASCIMENTO, ESTADO_CIVIL, STATUS, RG,CPF, TELEFONE, EMAIL, SENHA ,"
		+ " FILIAL,DEPARTAMENTO,CARGO,ESTADO,CIDADE, BAIRRO,LOGRADOURO, NUMERO,COMPLEMENTO)"
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
          PreparedStatement ps = conexao.prepareStatement("Select id, nome, cpf,email, status, cargo, "
          + "filial , departamento from TB_COLABORADOR");
    
          ResultSet rs = ps.executeQuery();
          List<Funcionario> funcionarios = new ArrayList<>();
    
         while(rs.next()) {
    	 funcionarios.add(new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
    	 rs.getString(6), rs.getString(7)));
        }
    
        return funcionarios;
	 
       }
	public void excluir(Integer cod)throws ClassNotFoundException, SQLException  {
		Connection conexao = ConexaoDatabase.getConexao();
		PreparedStatement statement = conexao.prepareStatement(
		"DELETE FROM TB_COLABORADOR WHERE id = ?");

		statement.setInt(1, cod);
		statement.execute();
	  }
	public Funcionario getFuncionarioId(Integer cod) throws SQLException, ClassNotFoundException  {
		Connection conexao = ConexaoDatabase.getConexao();
		PreparedStatement ps = conexao.prepareStatement("SELECT id, nome, Cpf, Rg, Sexo,"
		+ "ESTADO_CIVIL, NASCIMENTO, Estado, Cidade, bairro, Logradouro, Numero,complemento, Telefone,"
		+ "Email,STATUS, Senha, Cargo, Filial, Departamento FROM TB_COLABORADOR WHERE id=?");
                ps.setInt(1, cod);
		ResultSet rs =  ps.executeQuery();
		
		if (rs.next()) {
		 return new Funcionario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
		rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
		rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14),
                rs.getString(15), rs.getString(16), rs.getString(17), rs.getString(18), rs.getString(19),rs.getString(20));
		}
		throw new SQLException("Codigo não encontrado: " +cod);
	  }
	public void atualizar(Funcionario funcionario) throws ClassNotFoundException, SQLException  {
		Connection conexao = ConexaoDatabase.getConexao();
		PreparedStatement statement = conexao.prepareStatement(
		" UPDATE TB_COLABORADOR SET nome=?, cpf=?, rg=?, sexo=?, ESTADO_CIVIL=?, NASCIMENTO=?, estado=?, cidade=?, bairro=?,  logradouro=?,"
		+ " numero=?,complemento=?, telefone=?,email=?,STATUS=?, senha=?, cargo=?, filial=?, departamento=? WHERE id=?");

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
  
	public static List<Funcionario> buscar(String busca)throws SQLException, Exception {
	  String sql = "SELECT * FROM TB_COLABORADOR WHERE ID like ? or NOME like ? or CPF like ? \n"
          + "or EMAIL like ? or STATUS like ? or CARGO like ? or FILIAL like ? or DEPARTAMENTO like ? ";
           busca = busca+ '%';
		  
		  List <Funcionario> listaFuncionario = null;
		  
		  Connection conexao = null;
		  
		  PreparedStatement ps = null;
		  
		  ResultSet rs = null;
		  
		  try {
			conexao = ConexaoDatabase.getConexao();
			ps = conexao.prepareStatement(sql);
			ps.setString(1, busca);
			ps.setString(2, busca);
			ps.setString(3, busca);
			ps.setString(4, busca);
			ps.setString(5, busca);
			ps.setString(6, busca);
			ps.setString(7, busca);
                        ps.setString(8, busca);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(listaFuncionario == null) {
			           listaFuncionario = new ArrayList<>();
				}
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
                                String status = rs.getString("status");
				String cargo = rs.getString("cargo");
				String filial = rs.getString("filial");
				String departamento = rs.getString("departamento");
				
				Funcionario F = new Funcionario(cargo, filial, departamento, id, nome, cpf, email, status);
				listaFuncionario.add(F);
			}
			
		} catch (Exception e) {
			e.getMessage();
			System.out.println(e);
		}finally {
			if(rs != null && !rs.isClosed()) {
				rs.close();
			}
			if(ps != null && !ps.isClosed()) {
				ps.close();
			}
			if(conexao != null && !conexao.isClosed()) {
				conexao.close();
			}
		}
		  return listaFuncionario;
	}
}
	    


