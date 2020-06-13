package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 22/05/2020
 * @author Ramses
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não usado
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //declaracao de variáveis
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        try{
            //instancia de classes
            Funcionario funcionario = new Funcionario("null", "null");
            FuncionarioDao funcionarioDao = new FuncionarioDao();
        
            //procura funcionario pelo email
            funcionario = funcionarioDao.obterFuncionarioEmail(email);
            
            //verifica se achou o email 
            if(funcionario != null){
                //verifica se senha esta correta
                if(senha.equals(funcionario.getSenha())){
                    //verifica se funcionario esta ATIVO
                    if("Ativo".equals(funcionario.getStatus())){
                        //nova instancia de sessao
                        HttpSession sessao = request.getSession();
                        sessao.setAttribute("funcionarioSessao", funcionario);
                        //encaminha para a pagina inicial do sistema
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/start.jsp");
                        dispatcher.forward(request, response);
                    }else{
                        request.setAttribute("mensagemErro","Sinto-lhe informar, mas você foi desligado(a)! :(");
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                    }
                }else{
                    request.setAttribute("mensagemErro","Senha incorreta!");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request, response);
                }
            }else{
                request.setAttribute("mensagemErro","Email incorreto!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
                dispatcher.forward(request, response);
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
