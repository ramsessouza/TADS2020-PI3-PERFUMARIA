package com.muchachos.servelet;

import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valter Lafuente Junior
 */
 
@WebServlet(name = "funcionarioServlet", urlPatterns = {"/funcionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //não estamos usando doGet
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();
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
            funcionarioDao.salvar(funcionario);
            response.getWriter().write("O Funcionario '" + funcionario.getNome() + "' foi cadastrado com sucesso!!!");

        } catch (SQLException e) {
            response.getWriter().write("Erro de banco de dados: " + e.getMessage());

        } catch (ClassNotFoundException e) {
            response.getWriter().write("Erro de Driver: " + e.getMessage());
        } catch (Exception e) {
            response.getWriter().write("Erro de Código: " + e.getMessage());
        }
    }
}