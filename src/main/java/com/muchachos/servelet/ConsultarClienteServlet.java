package com.muchachos.servelet;

import com.muchachos.dao.ClienteDao;
import com.muchachos.model.Cliente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 13/05/2020
 * @author Otavio Barros
 */
@WebServlet(name = "ConsultarClienteServlet", urlPatterns = {"/ConsultarClienteServlet"})
public class ConsultarClienteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//usado apenas apos a exclusao
        
        ClienteDao clienteDao = new ClienteDao();
        
        try{
            List<Cliente> clientes = clienteDao.listar();
            request.setAttribute("clientes", clientes);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaCliente.jsp");
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
            throws ServletException, IOException {
        String campoPesquisa = request.getParameter("pesquisaCliente");
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        try{
            if (campoPesquisa == null || "".equals(campoPesquisa) ){//se tiver vazio lista tudo    
                List<Cliente> clientes = clienteDao.listar();
                request.setAttribute("clientes", clientes);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaCliente.jsp");
                dispatcher.forward(request,response);

            }else{//pesquisa por parametro
                List<Cliente> clientes = clienteDao.procurar(campoPesquisa);
                request.setAttribute("clientes", clientes);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaCliente.jsp");
                dispatcher.forward(request,response);  
            }
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
