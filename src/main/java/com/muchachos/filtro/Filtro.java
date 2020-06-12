package com.muchachos.filtro;

import com.muchachos.model.Funcionario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
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
        
        //se a tela acessada for diferente de index.jsp ou diferente de LoginServlet nao filtra
        if(!urlAcessada.contains("/index") && !urlAcessada.contains("/LoginServlet")){
            //Verifica se usuario ja esta deslogado
            HttpSession sessao = httpRequest.getSession();
            if(sessao.getAttribute("funcionarioSessao") == null){
                //se estiver deslogado envia para tela de login
                httpResponse.sendRedirect(httpRequest.getContextPath() + "/index.jsp");
                return;
            }

            //verifica se tem acesso a pagina especifica (TEM QUE TERMINAR ESSA PARTE)
            Funcionario funcionarioLogado = (Funcionario) sessao.getAttribute("funcionarioSessao");
            verificarAcesso(funcionarioLogado, urlAcessada);
        }
        //segue com a solicitacao
        chain.doFilter(request, response);
    }
    
    private boolean verificarAcesso(Funcionario funcionario, String urlAcessada){
        if(urlAcessada.contains("/buscaFuncionario")){
        }
        
        return false;
    }
    
    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        
    }
}
