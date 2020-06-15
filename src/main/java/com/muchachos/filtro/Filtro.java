package com.muchachos.filtro;

import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 10/06/2020 23:26
 * @author Ramses
 */
@WebFilter(filterName = "Filtro", urlPatterns = {"/*"})
public class Filtro implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String urlAcessada = httpRequest.getRequestURI();
        HttpSession sessao = httpRequest.getSession();
        Funcionario funcionarioLogado = new Funcionario();
                
        //Se a solicitacao for para /index ou loginServlet ou /css ou /fonts ou / img ou /js
        if(urlAcessada.contains("/index") || urlAcessada.contains("/LoginServlet") 
                || urlAcessada.contains("/css") || urlAcessada.contains("/fonts") 
                || urlAcessada.contains("/img") || urlAcessada.contains("/js")){
            
            //segue com a solicitacao normalmente
            chain.doFilter(request, response);
        }else{
            //Verifica se usuario esta logado
            if(sessao.getAttribute("funcionarioSessao") == null){
                //se estiver deslogado envia para tela de login
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
                return;
            }
            //Pega funcionario ativo na sessao
            funcionarioLogado = (Funcionario) sessao.getAttribute("funcionarioSessao");
            
            //Se for admin tem acesso a todas as paginas 
            if(funcionarioLogado.getEmail().equals("admin@muchachos")){
                //segue com a solicitacao normalmente
                chain.doFilter(request, response);
                return;
            }
            
            //verifica se tem acesso a pagina especifica (RESTRICAO DE ACESSO POR DEPARTAMENTO OU CARGO)
            if(verificarAcesso(funcionarioLogado, urlAcessada)){
                //segue com a solicitacao
                chain.doFilter(request, response);  
            }else{
                //mostra tela de erro avisando que nao tem acesso
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/unauthorized.jsp");
            }
        }
    }
    
    //VERIFICA SE USUARIO TEM ACESSO AO MODULO
    private boolean verificarAcesso(Funcionario funcionario, String urlAcessada){
        //TODOS DEVEM TER ACESSO!
        if(urlAcessada.contains("error.jsp") || urlAcessada.contains("main.jsp") || urlAcessada.contains("start.jsp")
                || urlAcessada.contains("unauthorized.jsp") || urlAcessada.contains("LogoutServlet")){
            return true;
        }
        //Se funcionario for DIRETOR OU GERENTE
        if(funcionario.getCargo().equals("Diretor") || funcionario.getCargo().equals("Gerente")){
            //se a url acessada for relacionada ao cargo de DIRETOR OU GERENTE
            if(urlAcessada.contains("relatorios.jsp") || urlAcessada.contains("DetalhesServlet")
                    || urlAcessada.contains("RelatoriosServlet")){
                return true;
            }
            return false;
        }
        //Se funcionario for do departamento de VENDA
        if(funcionario.getDepartamento().equals("Venda")){
            //se a url acessada for relacionada ao departamento de VENDA
            if(urlAcessada.contains("cadastroCliente.jsp") || urlAcessada.contains("consultaCliente.jsp")
                    || urlAcessada.contains("editarCliente.jsp") || urlAcessada.contains("venda.jsp")
                    || urlAcessada.contains("buscaProdutoServlet") || urlAcessada.contains("CadastroClienteServlet") 
                    || urlAcessada.contains("CadastroItensVendaServlet") || urlAcessada.contains("CadastroVendaServlet") 
                    || urlAcessada.contains("consultaProdutoServlet") || urlAcessada.contains("ConsultarClienteServlet")
                    || urlAcessada.contains("EditarClienteServlet") || urlAcessada.contains("ExcluirClienteServlet")){
                return true;
            }
        }
        //Se funcionario for do departamento de MARKETING
        if(funcionario.getDepartamento().equals("Marketing")){
            //se a url acessada for relacionada ao departamento de MARKETING
            if(urlAcessada.contains("buscaProduto.jsp") || urlAcessada.contains("cadastroProduto.jsp")
                    || urlAcessada.contains("consultaCliente.jsp") || urlAcessada.contains("consultaProduto.jsp") 
                    || urlAcessada.contains("editarProduto.jsp") || urlAcessada.contains("buscaProdutoServlet")
                    || urlAcessada.contains("CadastroProdutoServlet") || urlAcessada.contains("consultaProdutoServlet")
                    || urlAcessada.contains("ConsultarClienteServlet") || urlAcessada.contains("editarProdutoServlet")
                    || urlAcessada.contains("excluirProdutoServlet")){
                return true;
            }
        }
        //Se funcionario for do departamento de TECNOLOGIA DA INFORMACAO
        if(funcionario.getDepartamento().equals("TI")){
            //se a url acessada for relacionada ao departamento de TECNOLOGIA DA INFORMACAO
            if(urlAcessada.contains("buscaFuncionario.jsp") || urlAcessada.contains("cadastroFuncionario.jsp")
                    || urlAcessada.contains("consultaFuncionario.jsp") || urlAcessada.contains("editarFuncionario.jsp")
                    || urlAcessada.contains("buscarFuncionarioServlet") || urlAcessada.contains("consultaFuncionarioServlet")
                    || urlAcessada.contains("editarFuncionarioServlet") || urlAcessada.contains("excluirFuncionarioServlet")
                    || urlAcessada.contains("funcionarioServlet")){
                return true;
            }
        }
        //Se funcionario for do departamento de RECURSOS HUMANOS
        if(funcionario.getDepartamento().equals("Recursos Humanos")){
            //se a url acessada for relacionada ao departamento de RECURSOS HUMANOS
            if(urlAcessada.contains("buscaFuncionario.jsp") || urlAcessada.contains("consultaFuncionario.jsp")
                    || urlAcessada.contains("buscarFuncionarioServlet") || urlAcessada.contains("consultaFuncionarioServlet")){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig)throws ServletException {
    }
}
