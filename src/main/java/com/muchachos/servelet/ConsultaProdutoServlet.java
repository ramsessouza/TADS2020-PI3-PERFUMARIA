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
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "consultaProdutoServlet", urlPatterns = {"/consultaProdutoServlet"})
public class ConsultaProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//usado apenas apos a exclusao

        ProdutoDao produtoDao = new ProdutoDao();

        try {
            List<Produto> produtos = produtoDao.getProduto();
            request.setAttribute("produtos", produtos);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProduto.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("mensagemErro", "Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagemErro", "Erro de Driver: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nomeProduto = request.getParameter("nomeProduto");
        ProdutoDao produtoDao = new ProdutoDao();
        String json = null;
        try {
            List<Produto> produtos = produtoDao.buscarDireito(nomeProduto);
            json = new Gson().toJson(produtos);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        } catch (SQLException e) {
            response.getWriter().write("Erro de banco de dados: " + e.getMessage());

        } catch (Exception e) {
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
