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
 *
 * @author Diego Souza de Queiroz
 */
@WebServlet(name = "produtoServlet", urlPatterns = {"/produtoServlet"})
public class ProdutoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private final ProdutoDao produtoDao = new ProdutoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acao = request.getParameter("acao");
        String id = request.getParameter("id");
        try {
            if (acao != null && acao.equals("Editar")) {
                Integer cod = Integer.parseInt(id);
                Produto produto = produtoDao.getProdutoId(cod);
                request.setAttribute("produto", produto);
            }
            request.setAttribute("produtos", produtoDao.getProduto());

        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/editarProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = (request.getParameter("nome"));
        float preco = Float.parseFloat(request.getParameter("preco"));
        int quantidade = Integer.parseInt(request.getParameter("quantidade"));
        String descricao = request.getParameter("descricao");
        String categoria = request.getParameter("categoria");
        String status = request.getParameter("status");
        String id = request.getParameter("id");

        Produto produto = new Produto(null, nome, preco, quantidade, descricao, categoria, status);
        if (id != null && !id.equals("")) {
            produto.setId(Integer.parseInt(id));
        }
        try {
            if (produto.getId() != null) {
                
                produtoDao.atualizar(produto);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaProduto.jsp");
                dispatcher.forward(request, response);
                request.setAttribute("mensagem", "Produto atualizado com sucesso!!!");
            } else {
                produtoDao.salvar(produto);
                 RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroProduto.jsp");
                dispatcher.forward(request, response);
                request.setAttribute("mensagem", "Produto salvo com sucesso!!!");
            }
        } catch (SQLException e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
            request.setAttribute("produto", produto);

        } catch (ClassNotFoundException e) {
            request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
            request.setAttribute("produto", produto);
        }
       
    }
}
