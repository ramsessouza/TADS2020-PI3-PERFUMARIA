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

/**
 *
 * @author Valter Lafuente Junior
 */
 
@WebServlet(name = "editarFuncionarioServlet", urlPatterns = {"/editarFuncionarioServlet"})
public class EditarFuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {//aqui se usa quando seleciona editar na consulta de Funcionario
        String id = request.getParameter("id");
        int idInt = Integer.parseInt(id);
        Funcionario funcionario = new Funcionario();
        FuncionarioDao funcionarioDao = new FuncionarioDao();

        try {
            funcionario = funcionarioDao.getFuncionarioId(idInt);
            request.setAttribute("funcionario", funcionario);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarFuncionario.jsp");
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
            throws ServletException, IOException {//aqui se usa quando salva a edicao na tela de edicao de funcionario

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();
        String id = request.getParameter("id");
        funcionario.setId(Integer.parseInt(id));
		funcionario.setNome(request.getParameter("nome"));
		funcionario.setSexo(request.getParameter("sexo"));
		funcionario.setDataNascimento(request.getParameter("dataNascimento"));
		funcionario.setEstadoCivil(request.getParameter("estadoCivil"));
		funcionario.setStatus(request.getParameter("status"));
		funcionario.setRg(request.getParameter("rg"));
		funcionario.setCpf(request.getParameter("cpf"));
		funcionario.setTelefone(request.getParameter("telefone"));
		funcionario.setEmail(request.getParameter("email"));
		funcionario.setSenha(request.getParameter("senha"));
		funcionario.setFilial(request.getParameter("filial"));
		funcionario.setDepartamento(request.getParameter("departamento"));
		funcionario.setCargo(request.getParameter("cargo"));
		funcionario.setEstado(request.getParameter("estado"));
		funcionario.setCidade(request.getParameter("cidade"));
		funcionario.setBairro(request.getParameter("bairro"));
		funcionario.setLogradouro(request.getParameter("logradouro"));
		funcionario.setNumero(Integer.parseInt(request.getParameter("numero")));
		funcionario.setComplemento(request.getParameter("complemento"));

        try {
            //salvo a atualizacao no banco chamando a dao
            funcionarioDao.atualizar(funcionario);
            //Reencaminho a solicitacao para editarFuncionarioervlet assim pesquisando o funcionario alterado novamente
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/consultaFuncionarioServlet");
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

