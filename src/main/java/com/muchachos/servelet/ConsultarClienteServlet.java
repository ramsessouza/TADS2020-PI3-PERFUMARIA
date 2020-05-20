package com.muchachos.servelet;

import com.google.gson.Gson;
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
        String cpf = request.getParameter("cpf");
        String acao = request.getParameter("acao");
        String json = null;
        ClienteDao clienteDao = new ClienteDao();
        Cliente cliente = new Cliente();
        
        //Pesquisa por CPF (usado na Venda)
        if (acao != null){
            try{
                cliente = clienteDao.obter2(cpf);
                json = new Gson().toJson(cliente);
                if(cliente==null){//se nao encontrar o CPF
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Não encontrado!");
                }else{//se encontrar o cpf
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    //response.getWriter().write(cliente.getNome());
                }
            }catch (SQLException e){
                response.getWriter().write("Erro de banco de dados: " + e.getMessage());
            }catch (ClassNotFoundException e) {
                response.getWriter().write("Erro de Driver: " + e.getMessage());
            }
        //Pesquisa por nome (usado na consulta Cliente)
        }else{
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
}
