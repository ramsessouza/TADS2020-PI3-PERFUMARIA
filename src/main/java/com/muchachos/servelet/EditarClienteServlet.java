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
 * 15/05/2020
 * @author Otavio Barros
 */
@WebServlet(name = "EditarClienteServlet", urlPatterns = {"/EditarClienteServlet"})
public class EditarClienteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//aqui se usa quando seleciona editar na consulta de cliente
        String id = request.getParameter("id");
        Integer idInt = Integer.parseInt(id);
        Cliente cliente =  new Cliente();
        ClienteDao clienteDao = new ClienteDao();
        
        try{
            cliente = clienteDao.obter(idInt);
            request.setAttribute("cliente", cliente);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarCliente.jsp");
            dispatcher.forward(request,response);  
            
        }catch (SQLException e){
            request.setAttribute("mensagemErro","Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);

        }catch (ClassNotFoundException e) {
            request.setAttribute("mensagemErro","Erro de Driver: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//aqui se usa quando salva a edicao na tela de edicao de cliente
        
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        String id = request.getParameter("id");
        cliente.setId(Integer.parseInt(id));
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
            //salvo a atualizacao no banco chamando a dao
            clienteDao.atualizar(cliente);
            //Reencaminho a solicitacao para ConsultarClienteServlet assim pesquisando o cliente alterado novamente
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ConsultarClienteServlet");
            dispatcher.forward(request,response);
            
        }catch (SQLException e){
            request.setAttribute("mensagemErro","Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);

        }catch (ClassNotFoundException e) {
            request.setAttribute("mensagemErro","Erro de Driver: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        }
    }
}
