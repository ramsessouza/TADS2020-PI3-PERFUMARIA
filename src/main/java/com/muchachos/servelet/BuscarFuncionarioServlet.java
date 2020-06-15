package com.muchachos.servelet;

import com.google.gson.Gson;
import com.muchachos.dao.FuncionarioDao;
import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/buscarFuncionarioServlet")
public class BuscarFuncionarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
            List<Funcionario> listaFuncionario = FuncionarioDao.buscar(request.getParameter("Busca"));
            request.setAttribute("listaFuncionario", listaFuncionario);	
			
	} catch (Exception e) {
            request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	   }
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/buscaFuncionario.jsp");
            dispatcher.forward(request, response);
	}  
	
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        FuncionarioDao funcionarioDao = new FuncionarioDao();
        Funcionario funcionario = new Funcionario();
        String json = null;
        
            try{
                funcionario = funcionarioDao.obterFuncionarioCpf(cpf);
                json = new Gson().toJson(funcionario);
                if(funcionario==null){//se nao encontrar o CPF
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write("Não encontrado!");
                }else{//se encontrar o cpf
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);
                    //response.getWriter().write(cliente.getNome());
                }
            }catch (SQLException e){
                response.getWriter().write("Erro de banco de dados: " + e.getMessage());
            }catch (ClassNotFoundException e) {
                response.getWriter().write("Erro de Driver: " + e.getMessage());
            }
        }
    }

