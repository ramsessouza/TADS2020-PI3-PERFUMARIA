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
@WebServlet(name = "consultaProdutoServlet", urlPatterns = {"/consultaProdutoServlet"})
public class ConsultaProdutoServlet extends HttpServlet {

    private final ProdutoDao produtoDao = new ProdutoDao();
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        try {
            if (acao != null && acao.equals("Excluir")) {
                Integer cod = Integer.parseInt(id);
                produtoDao.excluir(cod);
                request.setAttribute("mensagem", "Produto Excluido com sucesso!!");
            }
            request.setAttribute("produtos", produtoDao.getProduto1());

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados");

        } catch (ClassNotFoundException e) {

            request.setAttribute("mensagem", "Erro de driver");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/consultaProduto.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//usado para pesquisa na tela de venda

        String nomeProduto = request.getParameter("nomeProduto");
        ProdutoDao produtoDao = new ProdutoDao();
        try {
            List<Produto> produtos = produtoDao.buscar(nomeProduto);
            request.setAttribute("produtos", produtos);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/venda.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            request.setAttribute("mensagemErro","Erro de banco de dados: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        } catch (Exception e) {
            request.setAttribute("mensagemErro","Erro de Código: " + e.getMessage());
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/error.jsp");
            dispatcher.forward(request,response);
        }
    }
}
