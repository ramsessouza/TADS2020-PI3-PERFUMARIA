package com.muchachos.servelet;

import com.muchachos.dao.ProdutoDao;
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
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "excluirProdutoServlet", urlPatterns = {"/excluirProdutoServlet"})
public class ExcluirProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer idInt = Integer.parseInt(id);
        
        ProdutoDao ProdutoDao = new ProdutoDao();
        try{
            //faz a exclusao do cliente via dao
            ProdutoDao.excluir(idInt);
            //Reencaminho a solicitacao para ConsultarClienteServlet assim pesquisando o cliente alterado novamente
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProdutoServlet");
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
        //não estamos usando doPost
    }
}
