package com.muchachos.servelet;

import com.muchachos.dao.ClienteDao;
import com.muchachos.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 12/05/2020
 * @author Otavio Barros
 */

@WebServlet(name = "CadastroClienteServlet", urlPatterns = {"/CadastroClienteServlet"})
public class CadastroClienteServlet extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não estamos usando doGet
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        cliente.setNome(request.getParameter("nome"));
        cliente.setSexo(request.getParameter("sexo"));
        cliente.setDataNascimento(request.getParameter("dataNascimento"));
        cliente.setEstadoCivil(request.getParameter("estadoCivil"));
        cliente.setStatus(request.getParameter("status"));
        cliente.setRg(request.getParameter("rg"));
        cliente.setCpf(request.getParameter("cpf"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setEstado(request.getParameter("estado"));
        cliente.setCidade(request.getParameter("cidade"));
        cliente.setBairro(request.getParameter("bairro"));
        cliente.setCep(request.getParameter("cep"));
        cliente.setLogradouro(request.getParameter("logradouro"));
        cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
        cliente.setComplemento(request.getParameter("complemento"));
        
        try{
            clienteDao.salvar(cliente);
            response.getWriter().write("Funcionario salvo com sucesso!!!");
            
        }catch (SQLException e){
           response.getWriter().write("Erro de banco de dados: " + e.getMessage());
            
        }catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        }catch (Exception e){
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
