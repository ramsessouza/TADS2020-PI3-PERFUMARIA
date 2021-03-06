<%-- 
    Document   : editarProduto
    Created on : 12/05/2020, 15:33:57
    Author     : Diego Souza de Queirozs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <!-- Meta tags Obrigatórias -->
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name=viewport content="width=device-width, initial-scale=1">
        <!--Específica da Página-->
        <link href="css/cadastros.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Edição de Produto</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">

            <!--Formulário Geral-->
            <form id="formulario" class="formulario" action="editarProdutoServlet" method="post">
                                                             
                <h1 class="titulo-formulario">Editar Produto: ${produto.nome}</h1> 
                <!--Linha 1-->
                <div class="row linha-do-nome">

                    <div class="col-md-11 col-sm-11">
                        <input type="hidden" name="id" value="${produto.id}">
                    </div>

                    <!--Nome do Produto-->
                    <div class="col-sm-10 col-md-10">
                        <div class="form-group">
                            <label for="nome">Nome do Produto</label>
                            <input id="nome" name="nome" value="${produto.nome}" maxlength="40" type="text" class="form-control" required >
                        </div>
                    </div><!--Fim do Nome do Produto-->
                    <!--Ativo-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Status</label>
                            <select id="status" name='status' class="form-control">
                                <option value="${produto.status}">${produto.status}</option> 
                                <option value="ativo">Ativo</option>
                                <option value="inativo">Inativo</option>
                            </select>
                        </div>
                    </div><!--Fim Ativo-->
                </div><!--Fim da linha 1-->
                <!--Linha 2-->  
                <div class="row">
                    <!--Categoria-->
                    <div class="dropdown col-sm-6">
                        <div class="form-group">
                            <label for="categoria">Categoria</label>
                            <select id="categoria" name="categoria" class="form-control" required>
                                <option value="${produto.categoria}">${produto.categoria}</option>
                                <option value="beleza">Beleza</option>
                                <option value="cosmeticos">Cosmeticos</option>
                                <option value="perfumes">Perfumes</option>
                                <option value="utensilios">Utensilios</option>
                            </select>
                        </div>
                    </div><!--Fim da Categoria-->
                    <!--Preco-->
                    <div class="col-sm-4">
                        <div class="form-group">
                            <label for="preco">Preço</label>
                            <input id="preco" name="preco" value="${produto.preco}" class="form-control mascara-decimais" required >
                        </div>
                    </div><!--Fim do preco-->
                    <!--Quantidade-->
                    <div class="col-sm-2">
                        <div class="form-group">  
                            <label for="quantidade">Quantidade</label> 
                            <input id="quantidade" name="quantidade" type="number" class="form-control mascara-numero" value="${produto.quantidade}" required>
                        </div>
                    </div><!--Fim Quantidade-->
                </div><!--Fim da linha 2-->
                <!--Linha 3-->
                <div class="row">
                    <!--Descricao-->
                    <div class="col-sm-12" >
                        <div class="form-group">
                            <label for="descricao">Descrição</label>  
                            <input id="descricao" name="descricao" type="text" maxlength="200" class="form-control" value="${produto.descricao}" required>
                        </div>
                    </div><!--Fim Desricao-->
                </div><!--Fim da linha 3-->
                <!--Linha 4-->
                <!--Linha 6-->
                <div class="botoes">
                    <div class="row">
                        <div class=" offset-md-8 col-sm-2">

                        </div>
                        <div class="col-sm-2">
                            <!--Botão Salvar-->
                            <input type="submit" value="Atualizar" class="btn btn-success btn-block">
                        </div>
                    </div><!--Fim da linha 4-->
                </div><!--Fim classe botoes-->
            </form><!--Fim do formulário-->
        </div><!--Fim do conteudo da pagina-->
        <!--1-jQuery.js-->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <!--2-Popper.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <!--3-Bootstrap.js -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <!--4-Mask Money Plugin-->
        <script src="https://cdn.rawgit.com/plentz/jquery-maskmoney/master/dist/jquery.maskMoney.min.js"></script>
        <!--5-Mask CPF Plugin-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.12/jquery.mask.min.js"></script>
        <!--6-Específica da página-->
        <script type="text/javascript" src="js/validacao.js"></script>
    </body>
</html>