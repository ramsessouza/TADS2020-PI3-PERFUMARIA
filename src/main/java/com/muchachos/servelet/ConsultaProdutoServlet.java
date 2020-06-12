package com.muchachos.servelet;

import com.google.gson.Gson;
import com.muchachos.dao.ProdutoDao;
import com.muchachos.model.Produto;
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
 * 13/05/2020
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "consultaProdutoServlet", urlPatterns = {"/consultaProdutoServlet"})
public class ConsultaProdutoServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//usado apenas apos a exclusao
        
        ProdutoDao produtoDao = new ProdutoDao();
        
        try{
            List<Produto> produtos = produtoDao.getProduto();
            request.setAttribute("produtos", produtos);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProduto.jsp");
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
        String nomeProduto = request.getParameter("nomeProduto");
        String acao = request.getParameter("acao");
        String json = null;
        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();
       
            try{
                if (campoPesquisa == null || "".equals(campoPesquisa) ){//se tiver vazio lista tudo    
                    List<Produto> produtos = produtoDao.getProduto();
                    request.setAttribute("produtos", produtos);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProduto.jsp");
                    dispatcher.forward(request,response);

                }else{//pesquisa por parametro
                    List<Produto> produtos = produtoDao.buscar(campoPesquisa);
                    request.setAttribute("produtos", produtos);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProduto.jsp");
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
            Logger.getLogger(ConsultaProdutoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
