package com.muchachos.servelet;

import com.muchachos.dao.ProdutoDao;
import com.muchachos.model.Produto;
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
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet("/buscaProdutoServlet")
public class BuscaProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Produto> listaProduto = ProdutoDao.buscar(request.getParameter("Busca"));
            request.setAttribute("listaProduto", listaProduto);

        } catch (Exception e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/buscaProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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

}
