package com.muchachos.servelet;

import com.muchachos.dao.ProdutoDao;
import com.muchachos.model.Produto;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 12/06/2020
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "editarProdutoServlet", urlPatterns = {"/editarProdutoServlet"})
public class EditarProdutoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//aqui se usa quando seleciona editar na consulta de cliente
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();

        try {
            produto = produtoDao.getProdutoId(idInt);
            request.setAttribute("produto", produto);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarProduto.jsp");
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
            throws ServletException, IOException {//aqui se usa quando salva a edicao na tela de edicao de produto

        ProdutoDao produtoDao = new ProdutoDao();
        Produto produto = new Produto();
        String id = request.getParameter("id");
        produto.setId(Integer.parseInt(id));
        produto.setNome(request.getParameter("nome"));
        produto.setStatus(request.getParameter("status"));
        produto.setCategoria(request.getParameter("categoria"));
        produto.setPreco(Float.parseFloat(request.getParameter("preco")));
        produto.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
        produto.setDescricao(request.getParameter("descricao"));

        try {
            //salvo a atualizacao no banco chamando a dao
            produtoDao.atualizar(produto);
            //Reencaminho a solicitacao para editarProdutoServlet assim pesquisando o produto alterado novamente
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProdutoServlet");
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
