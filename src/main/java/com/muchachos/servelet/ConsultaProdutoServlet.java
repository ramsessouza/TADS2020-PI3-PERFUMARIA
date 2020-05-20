package com.muchachos.servelet;

import com.google.gson.Gson;
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
        String json = null;
        try {
            List<Produto> produtos = produtoDao.buscarDireito(nomeProduto);
            json = new Gson().toJson(produtos);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }catch (SQLException e){
           response.getWriter().write("Erro de banco de dados: " + e.getMessage());
            
        }catch (Exception e) {
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}
