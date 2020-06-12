<%-- 
    Document   : buscaProduto
    Created on : 14/05/2020, 21:24:27
    Author     : Diego Souza de Queiroz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <!-- Meta tags ObrigatÃ³rias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--CSS -->
        <!--Fonts Awesome-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
        <!--Bootstrap-->

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <!--EspecÃ­fica da PÃ¡gina-->
        <link href="css/start.css" rel="stylesheet">
        <link href="css/consultas.css" rel="stylesheet">
        <link href="css/componentes.css" rel="stylesheet">

        <!-- 
         <link href="css/componentes.css" rel="stylesheet">
        -->
        <link href="css/consultaProduto.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Consulta Produto</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <h1>Consulta de Produto</h1>
            <!--FormulÃ¡rio-->
            <form clas="formulario" action="buscaProdutoServlet"  method="get">  
                <!--Linha 1-->
                <div class="row">
                    <div class="col-sm-5">
                        <!--Campo de Pesquisa de produto-->
                        <div class="input-group mb-2 mr-sm-2">
                            <div class="input-group-prepend ">
                                <div class="input-group-text">
                                    <span class="fas fa-pump-soap mr-1"></span>
                                </div>
                            </div>
                             <input class="form-control" placeholder="Pesquisar Produto por nome" type="text" name="Busca">
                        </div><!--Fim do campo de Pesquisa de produto-->
                    </div>
                    <div class="col-sm-2">
                        <button class="btn btn-dark btn-block" type="submit" value= "Busca" >Pesquisar
                            <span class="ml-1 fas fa-search"></span>
                        </button>
                    </div>
                </div><!--Fim da linha 1--> 
            </form><!--Fim do formulario-->  
            <!--Tabela--> 
            <div class="tabela">
                <table class="table table-sm table-secondary table-hover table-striped">   
                    <thead class="thead-dark">
                        <tr>
                            <th>ID</th>
                            <th>PRODUTO</th>
                            <th>QUANTIDADE</th>
                            <th>CATEGORIA</th>
                            <th>VALOR</th>
                            <th>STATUS</th>
                            <th>EDITAR</th>
                            <th>REMOVER</th>
                        </tr>
                    </thead>
                    <c:forEach var="p" items="${listaProduto}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.nome}</td>
                            <td>${p.quantidade}</td>
                            <td>${p.categoria}</td>
                            <td>${p.preco}</td>                                                                                
                            <td>${p.status}</td>
                            <td><a href=produtoServlet?acao=Editar&id=${p.id}><span class="fas fa-edit"</span></a></td>
                            <td><a href=consultaProdutoServlet?acao=Excluir&id=${p.id}><span class="fas fa-times"></span></a></td>
                        </tr>
                    </c:forEach>        
                </table>
              </div>
            <h1>&nbsp;</h1>
            </div><!--Fim da Tabela--> 
            <!--1-jQuery.js-->
            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <!--2-Popper.js-->
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
            <!--3-Bootstrap.js-->
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
            <!--4-EspecÃ­fica da pÃ¡gina-->
            <script type="text/javascript" src="js/start.js"></script>
    </body>
</html>