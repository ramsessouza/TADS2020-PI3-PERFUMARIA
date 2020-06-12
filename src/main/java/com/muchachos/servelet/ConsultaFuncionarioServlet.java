package com.muchachos.servelet;

import com.google.gson.Gson;
import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 
 
@WebServlet(name = "consultaFuncionarioServlet", urlPatterns = {"/consultaFuncionarioServlet"})
public class ConsultaFuncionarioServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//usado apenas apos a exclusao
        
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        
        try{
            List<Funcionario> funcionarios = funcionarioDao.getFuncionario();
            request.setAttribute("funcionarios", funcionarios);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaFuncionario.jsp");
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
        String campoPesquisa = request.getParameter("Busca");
        String nomeFuncionario = request.getParameter("nomeFuncionario");
        String acao = request.getParameter("acao");
        String json = null;
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();
       
            try{
                if (campoPesquisa == null || "".equals(campoPesquisa) ){//se tiver vazio lista tudo    
                    List<Funcionario> funcionarios = funcionarioDao.getFuncionario();
                    request.setAttribute("funcionarios", funcionarios);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaFuncionario.jsp");
                    dispatcher.forward(request,response);

                }else{//pesquisa por parametro
                    List<Funcionario> funcionarios = funcionarioDao.buscar(campoPesquisa);
                    request.setAttribute("funcionarios", funcionarios);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaFuncionario.jsp");
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
            } catch (Exception ex) {
            Logger.getLogger(ConsultaFuncionarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
