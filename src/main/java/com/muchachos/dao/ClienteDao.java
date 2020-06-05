package com.muchachos.dao;

import com.muchachos.db.ConexaoDatabase;
import com.muchachos.model.Cliente;
import com.muchachos.normalize.Normalize;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 12/05/2020
 * @author Otavio Barros
 */
public class ClienteDao extends ConexaoDatabase{

    public void salvar(Cliente cliente) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO TB_CLIENTE(nome, sexo, "
                + "nascimento, estado_civil, status, rg, cpf, email, "
                + "telefone, estado, cidade, bairro, cep, logradouro, "
                + "numero, complemento) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Normalize normal = new Normalize();
        
        try{
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, normal.removeAcento(cliente.getNome()));
            preparedStatement.setString(2, cliente.getSexo());
            preparedStatement.setString(3, cliente.getDataNascimento());
            preparedStatement.setString(4, normal.removeAcento(cliente.getEstadoCivil()));
            preparedStatement.setString(5, cliente.getStatus());
            preparedStatement.setString(6, cliente.getRg());
            preparedStatement.setString(7, cliente.getCpf());
            preparedStatement.setString(8, normal.removeAcento(cliente.getEmail()));
            preparedStatement.setString(9, cliente.getTelefone());
            preparedStatement.setString(10, normal.removeAcento(cliente.getEstado()));
            preparedStatement.setString(11, normal.removeAcento(cliente.getCidade()));
            preparedStatement.setString(12, normal.removeAcento(cliente.getBairro()));
            preparedStatement.setString(13, cliente.getCep());
            preparedStatement.setString(14, normal.removeAcento(cliente.getLogradouro()));
            preparedStatement.setInt(15, cliente.getNumero());
            preparedStatement.setString(16, normal.removeAcento(cliente.getComplemento()));
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
    
    public List<Cliente> listar() throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nome, sexo, nascimento, estado_civil, status, rg, "
                + "cpf, email, telefone, estado, cidade, bairro, cep, logradouro, "
                + "numero, complemento FROM TB_CLIENTE";
        
        List<Cliente> listaClientes = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try{
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);

            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setDataNascimento(result.getString("Nascimento"));
                cliente.setEstadoCivil(result.getString("estado_civil"));
                cliente.setStatus(result.getString("status"));
                cliente.setRg(result.getString("rg"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstado(result.getString("estado"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                
                listaClientes.add(cliente);
            }
        }finally{
            if(result != null && !result.isClosed()){
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }
    
    public List<Cliente> procurar(String nome) throws ClassNotFoundException, SQLException {
        String sql = "SELECT id, nome, sexo, nascimento, estado_civil, status, rg, "
                + "cpf, email, telefone, estado, cidade, bairro, cep, logradouro, "
                + "numero, complemento FROM TB_CLIENTE WHERE upper(nome) LIKE (?) OR CPF LIKE (?)";
        List<Cliente> listaClientes = null;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;        
        
        try{
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nome.toUpperCase() + "%");
            preparedStatement.setString(2, "%" + nome.toUpperCase() + "%");
            
            result = preparedStatement.executeQuery();
            
            while (result.next()) {
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setDataNascimento(result.getString("Nascimento"));
                cliente.setEstadoCivil(result.getString("estado_civil"));
                cliente.setStatus(result.getString("status"));
                cliente.setRg(result.getString("rg"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstado(result.getString("estado"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                
                listaClientes.add(cliente);
            }
        }finally{
            if(result != null && !result.isClosed()){
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return listaClientes;
    }
    
    public Cliente obter(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM TB_CLIENTE WHERE id =?";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            
            if(result.next()){
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setDataNascimento(result.getString("Nascimento"));
                cliente.setEstadoCivil(result.getString("estado_civil"));
                cliente.setStatus(result.getString("status"));
                cliente.setRg(result.getString("rg"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstado(result.getString("estado"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                
                return cliente;
            }
        }finally{
            if(result != null && !result.isClosed()){
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
    
    public Cliente obter2(String cpf) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM TB_CLIENTE WHERE CPF =? AND STATUS <> 'Inativo'";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, cpf);
            result = preparedStatement.executeQuery();
            
            if(result.next()){
                Cliente cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setNome(result.getString("nome"));
                cliente.setSexo(result.getString("sexo"));
                cliente.setDataNascimento(result.getString("Nascimento"));
                cliente.setEstadoCivil(result.getString("estado_civil"));
                cliente.setStatus(result.getString("status"));
                cliente.setRg(result.getString("rg"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setEmail(result.getString("email"));
                cliente.setTelefone(result.getString("telefone"));
                cliente.setEstado(result.getString("estado"));
                cliente.setCidade(result.getString("cidade"));
                cliente.setBairro(result.getString("bairro"));
                cliente.setCep(result.getString("cep"));
                cliente.setLogradouro(result.getString("logradouro"));
                cliente.setNumero(result.getInt("numero"));
                cliente.setComplemento(result.getString("complemento"));
                
                return cliente;
            }
        }finally{
            if(result != null && !result.isClosed()){
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
    
    public void atualizar(Cliente clienteAtualizado) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE TB_CLIENTE SET nome = ?, sexo = ?, "
                + "nascimento = ?, estado_civil = ?, status = ?, rg = ?, "
                + "cpf = ?, email = ?, telefone = ?, estado = ?, cidade = ?, "
                + "bairro = ?, cep = ?, logradouro = ?, numero = ?, complemento = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Normalize normal = new Normalize();
        
        try {
            
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, normal.removeAcento(clienteAtualizado.getNome()));
            preparedStatement.setString(2, clienteAtualizado.getSexo());
            preparedStatement.setString(3, clienteAtualizado.getDataNascimento());
            preparedStatement.setString(4, normal.removeAcento(clienteAtualizado.getEstadoCivil()));
            preparedStatement.setString(5, clienteAtualizado.getStatus());
            preparedStatement.setString(6, clienteAtualizado.getRg());
            preparedStatement.setString(7, clienteAtualizado.getCpf());
            preparedStatement.setString(8, normal.removeAcento(clienteAtualizado.getEmail()));
            preparedStatement.setString(9, clienteAtualizado.getTelefone());
            preparedStatement.setString(10, normal.removeAcento(clienteAtualizado.getEstado()));
            preparedStatement.setString(11, normal.removeAcento(clienteAtualizado.getCidade()));
            preparedStatement.setString(12, normal.removeAcento(clienteAtualizado.getBairro()));
            preparedStatement.setString(13, clienteAtualizado.getCep());
            preparedStatement.setString(14, normal.removeAcento(clienteAtualizado.getLogradouro()));
            preparedStatement.setInt(15, clienteAtualizado.getNumero());
            preparedStatement.setString(16, normal.removeAcento(clienteAtualizado.getComplemento()));
            preparedStatement.setInt(17, clienteAtualizado.getId());

            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
    
    public void excluir(Integer id) throws ClassNotFoundException, SQLException {
        String sql = "DELETE FROM TB_CLIENTE WHERE id = ?";         
             
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = getConexao();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            //Executa o comando no banco de dados
            preparedStatement.executeUpdate();
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
