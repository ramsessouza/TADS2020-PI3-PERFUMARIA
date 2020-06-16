<%-- 
    Document   : consultaCliente
    Created on : 05/05/2020, 18:32:39
    Author     : Otávio Barros
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--CSS -->
        <!--Fonts Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <!--Bootstrap-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--Específica da Página-->
        <link href="css/start.css" rel="stylesheet">
        <link href="css/consultas.css" rel="stylesheet">
        <link href="css/componentes.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Consulta de clientes</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <h1>Consulta de Clientes</h1>
            <!--Formulário-->
            <form class="formulario" action="ConsultarClienteServlet" method="POST"> 
                <!--Linha 1-->
                <div class="row">
                    <!--Coluna 1-->
                    <div class="col-sm-5">
                        <!--Campo de Pesquisa de cliente-->
                        <div class="input-group mb-2 mr-sm-2">
                            <div class="input-group-prepend ">
                                <div class="input-group-text">
                                    <span class="fas fa-users mr-1"></span>
                                </div>
                            </div>
                            <input name="pesquisaCliente" class="form-control" maxlength="40" placeholder="Pesquisar Cliente por Nome ou CPF" type="text">
                        </div><!--Fim do campo de Pesquisa de cliente-->
                    </div><!--Fim da Coluna 1-->
                    <!--Coluna 2-->
                    <div class="col-sm-2">
                        <!--Botão de Pesquisa de cliente-->
                        <button class="btn btn-dark btn-block" type="submit">Pesquisar
                            <span class="ml-1 fas fa-search"></span>
                        </button>
                    </div><!--Fim Coluna 2-->
                </div><!--Fim da linha 1--> 
            </form><!--Fim do formulario--> 
            <!--Tabela--> 
            <div class="tabela">
                <table class="table table-sm table-secondary table-hover table-striped">     
                    <thead class="thead-dark">
                        <tr>
                            <th class="td-id">#</th>
                            <th class="td-nome">NOME</th>
                            <th class="td-cpf">CPF</th>
                            <th class="td-email">E-MAIL</th>
                            <th class="td-telefone">TELEFONE</th>
                            <th class="td-cidade">CIDADE</th>
                            <th class="td-logradouro">LOGRADOURO</th>
                            <th>NÚMERO</th>
                            <th>STATUS</th>
                            <th class="td-editar">EDITAR</th>
                            <th class="td-remover">REMOVER</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="listaClientes" items="${clientes}">
                            <tr>
                                <td class="td-id">${listaClientes.id}</td>
                                <td class="td-nome">${listaClientes.nome}</td>
                                <td class="td-cpf">${listaClientes.cpf}</td>
                                <td class="td-email">${listaClientes.email}</td>
                                <td class="td-telefone">${listaClientes.telefone}</td>
                                <td class="td-cidade">${listaClientes.cidade}</td>
                                <td class="td-logradouro">${listaClientes.logradouro}</td>
                                <td>${listaClientes.numero}</td>
                                <td>${listaClientes.status}</td>
                                <td class="td-remover"><a href="EditarClienteServlet?&id=${listaClientes.id}"><span class="fas fa-edit"></span></a></td>
                                <td class="td-editar"><a href="ExcluirClienteServlet?&id=${listaClientes.id}"><span class="fas fa-times"></span></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div><!--Fim da Tabela-->
            <h1>&nbsp;</h1>
        </div>
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js-->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>