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
@WebServlet(name = "funcionarioServlet", urlPatterns = {"/funcionarioServlet"})
public class FuncionarioServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;
	private  FuncionarioDao funcionarioDao = new FuncionarioDao(); 
	      
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String id = request.getParameter("id");
		try {
                  if(acao != null && acao.equals("Excluir")) {
                    Integer cod = Integer.parseInt(id);
	            funcionarioDao.excluir(cod);
	            request.setAttribute("mensagem", "Funcionario Excluido com sucesso!!");
                }else if(acao != null && acao.equals("Editar")) {
		    Integer cod = Integer.parseInt(id); 
                    Funcionario funcionario = funcionarioDao.getFuncionarioId(cod);
                    request.setAttribute("funcionario", funcionario);
		}
		request.setAttribute("funcionarios", funcionarioDao.getFuncionario());	
			
		} catch (SQLException e) {
		request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			
	       }catch (ClassNotFoundException e) {
			
		request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
	      }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/editarFuncionario.jsp");
		dispatcher.forward(request, response);
	}
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
                String sexo = request.getParameter("sexo");
                String dataNascimento = request.getParameter("dataNascimento");
                String estadoCivil = request.getParameter("estadoCivil");
                String status = request.getParameter("status");
                String rg = request.getParameter("rg");
		String cpf = request.getParameter("cpf");
	        String telefone = request.getParameter("telefone");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String filial = request.getParameter("filial");
		String departamento = request.getParameter("departamento");
                String cargo = request.getParameter("cargo");
		String estado = request.getParameter("estado");
		String cidade = request.getParameter("cidade");
		String bairro = request.getParameter("bairro");
		String logradouro = request.getParameter("logradouro");
                int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String id = request.getParameter("id");
                
		Funcionario funcionario = new Funcionario(null,nome, cpf, rg, sexo, estadoCivil, dataNascimento,
		estado, cidade, bairro, logradouro, numero, complemento, telefone, email,status, senha, cargo, filial, departamento);
		if(id != null && !id.equals("")) {
			funcionario.setId(Integer.parseInt(id));
		}
		try {
			if(funcionario.getId() != null) {
				 funcionarioDao.atualizar(funcionario);
				 request.setAttribute("mensagem","Funcionario atualizado com sucesso!!!");
			}else {
			 funcionarioDao.salvar(funcionario);
			 request.setAttribute("mensagem","Funcionario salvo com sucesso!!!");
		  }
		} catch (SQLException e) {
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	    }catch (ClassNotFoundException e) {
			request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	   }
		try {
		  request.setAttribute("funcionario", funcionarioDao.getFuncionario());
	   } catch (SQLException e) {
		   
			request.setAttribute("mensagem", "Erro de banco de dados: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
			 
	    }catch (ClassNotFoundException e) {
	    	
			request.setAttribute("mensagem", "Erro de Driver: " + e.getMessage());
			 request.setAttribute("funcionario", funcionario);
	    }
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastroFuncionario.jsp");
		dispatcher.forward(request, response);
		
	   }
}