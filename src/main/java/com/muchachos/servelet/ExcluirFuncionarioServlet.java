package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valter Lafuente Junior
 */
 
@WebServlet(name = "excluirFuncionarioServlet", urlPatterns = {"/excluirFuncionarioServlet"})
public class ExcluirFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Integer idInt = Integer.parseInt(id);
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        try{
            //faz a exclusao do funcionario via dao
            funcionarioDao.excluir(idInt);
            //Reencaminho a solicitacao para ConsultarFuncionarioServlet assim pesquisando o funcionario alterado novamente
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaFuncionarioServlet");
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
