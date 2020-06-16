<%-- 
    Document   : cadastroFuncionario
    Created on : 03/05/2020, 00:47:31
    Author     : Valter Lafuente Junior
--%>

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
        <!--Página-->
        <link href="css/start.css" rel="stylesheet">
        <link href="css/cadastros.css" rel="stylesheet">
        <!--Titulo e icone-->
        <link rel="shortcut icon" href="img/logo-branco.png"/>
        <title>Perfumaria Muchachos: Início do sistema</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <!--Formulário Geral-->
            <form id="formulario" class="formulario" action="editarFuncionarioServlet" method="post">
                <h1 class="titulo-formulario">Editar Colaborador: ${funcionario.nome}</h1> 
                <!--Linha 1-->
                <div class="row linha-do-nome">

                    <div class="col-md-11 col-sm-11">
                        <input type="hidden" name="id"  value="${funcionario.id}">
                    </div>

                    <div class="col-md-9 col-sm-9">
                        <div class="form-group">
                            <label>Nome</label>
                            <input type="text" class="form-control" name="nome" value="${funcionario.nome}" id="nome" required maxlength="30">
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>Status</label>
                            <select name="status" id="status" class="form-control">
                                <option value="${funcionario.status}">${funcionario.status}</option>   
                                <option value="Ativo">Ativo</option>
                                <option value="Inativo">Inativo</option>
                            </select>
                        </div>
                    </div>
                </div><!--Fim Linha 1-->

                <!--Linha 2-->
                <div class="row">
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Nascimento</label>
                            <input name="dataNascimento" id="dataNascimento" type="date" class="form-control" value="${funcionario.dataNascimento}" required >
                        </div>
                    </div>
                   <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>RG</label>
                            <input name="rg" id="rg" type="text" class="form-control" value="${funcionario.rg}" maxlength="15" pattern="[a-zA-Z0-9-]+" placeholder="Apenas numeros e letra">
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <div class="form-inline inline-cpf">
                                <label>CPF</label>
                                <label id="mensagem-cpf"></label>
                            </div>
                            <input name="cpf" id="cpf" type="text" class="form-control mascara-cpf cpf-funcionario" value="${funcionario.cpf}" required  placeholder="Exemplo.: 522.498.635-49">
                        </div>
                    </div>
                    <div class="dropdown col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Estado Civil</label>
                            <select name="estadoCivil" id="estadoCivil" class="form-control" required >
                                <option value="${funcionario.estadoCivil}">${funcionario.estadoCivil}</option>     
                                <option value="Casado">Casado</option>
                                <option value="Solteiro">Solteiro</option>
                                <option value="Divorciado">Divorciado</option>
                                <option value="UniaoEstavel">União Estável</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Sexo</label>
                            <select name="sexo" id="sexo" class="form-control">
                                <option value="${funcionario.sexo}">${funcionario.sexo}</option>     
                                <option value="Masculino">Masculino</option>
                                <option value="Feminino">Feminino</option>
                            </select>
                        </div>
                    </div>
                </div><!--Fim Linha 2-->

                <!--Linha 3-->
                <div class="row">
                    <div class="col-md-8 col-sm-8">
                        <div class="form-group">
                            <label>Endereço</label>
                            <input name="logradouro" id="logradouro" type="text" class="form-control" maxlength="50" value="${funcionario.logradouro}" placeholder="Exemplo.: Av Rubens de Oliveira" required>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-2">
                        <div class="form-group">
                            <label>Número</label>
                            <input name="numero" id="numero" type="number" class="form-control mascara-numero" maxlength="6" placeholder="Exemplo.: 1359" value="${funcionario.numero}" required>
                        </div>
                    </div>  
                </div><!--Fim Linha 3-->

                <!--Linha 4-->
                <div class="row">
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Bairro</label>
                            <input name="bairro" id="bairro" type="text" class="form-control" value="${funcionario.bairro}" maxlength="40" placeholder="Exemplo.: Barueri">
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Cidade</label>
                            <input name="cidade" id="cidade" type="text" class="form-control" maxlength="40" placeholder="Exemplo.: Diadema" value="${funcionario.cidade}">
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Complemento</label>
                            <input name="complemento" id="complemento" type="text" class="form-control" maxlength="20" placeholder="Exemplo.: Torre 3" value="${funcionario.complemento}">
                        </div>
                    </div>
                </div><!--Fim Linha 4-->

                <!--Linha 5-->
                <div class="row">
                    <div class="col-md-3 col-sm-2">
                        <div class="form-group">
                            <label>Estado</label>
                            <select id="estado" name="estado" class="form-control">
                                <option value="${funcionario.estado}">${funcionario.estado}</option>   
                                <option value="acre">Acre</option>
                                <option value="alagoas">Alagoas</option>
                                <option value="amapa">Amapá</option>
                                <option value="amazonas">Amazonas</option>
                                <option value="bahia">Bahia</option>
                                <option value="ceara">Ceará</option>
                                <option value="distrito federal">Distrito Federal</option>
                                <option value="espirito santo">Espírito Santo</option>
                                <option value="goias">Goiás</option>
                                <option value="maranhao">Maranhão</option>
                                <option value="mato grosso">Mato Grosso</option>
                                <option value="mato grosso do sul">Mato Grosso do Sul</option>
                                <option value="minas gerais">Minas Gerais</option>
                                <option value="para">Pará</option>
                                <option value="paraiba">Paraíba</option>
                                <option value="parana">Paraná</option>
                                <option value="pernambuco">Pernambuco</option>
                                <option value="piaui">Piauí</option>
                                <option value="rio de janeiro">Rio de Janeiro</option>
                                <option value="rio grande do norte">Rio Grande do Norte</option>
                                <option value="rio grande do sul">Rio Grande do Sul</option>
                                <option value="rondonia">Rondônia</option>
                                <option value="roraima">Roraima</option>
                                <option value="santa catarina">Santa Catarina</option>
                                <option value="sao paulo">São Paulo</option>
                                <option value="sergipe">Sergipe</option>
                                <option value="tocantins">Tocantins</option>
                            </select>
                        </div>
                    </div><!--Fim Estado-->
                    <div class="col-md-9 col-sm-9">
                        <!--Linha 5.1-->
                        <div class="row">
                            <div class="col-md-6 col-sm-4">
                                <div class="form-group">
                                    <label>Telefone</label>
                                    <input name="telefone" id="telefone" type="text" class="form-control mascara-telefone" value="${funcionario.telefone}" placeholder="Exemplo.: 11991887754" required>
                                </div>
                            </div> 
                            <div class="col-md-6 col-sm-4">
                                <div class="form-group">
                                    <label>E-mail</label>
                                    <input name="email" id="email" type="email" class="form-control" value="${funcionario.email}" placeholder="Exemplo.: runekerub216@muchachos.com" required maxlength="40">
                                </div>
                            </div>
                        </div><!--Fim Linha 5.1-->  
                    </div>
                </div><!--Fim Linha 5-->

                <div class="row">
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>Departamento</label>
                            <select name="departamento" id="departamento" class="form-control">
                                <option value="${funcionario.departamento}">${funcionario.departamento}</option>     
                                <option value="Venda">Venda</option>
                                <option value="Marketing">Marketing</option>
                                <option value="Recursos Humanos">Recursos Humanos</option>
                                <option value="TI">TI</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-md-9 col-sm-9">
                        <!--Linha 5.1-->
                        <div class="row">
                            <div class="col-md-4 col-sm-4">
                                <div class="form-group">
                                    <label>Cargo</label>
                                    <select name="cargo" id="cargo" class="form-control">
                                        <option value="${funcionario.cargo}">${funcionario.cargo}</option>     
                                        <option value="Vendedor">Vendedor</option>
                                        <option value="Analista de Marketing">Analista de Marketing</option>
                                        <option value="Analista de RH">Analista de RH</option>
                                        <option value="Analista de TI">Analista de TI</option>
                                        <option value="Gerente">Gerente</option>
                                        <option value="Diretor">Diretor</option>
                                    </select>
                                </div>
                            </div>  
                            <div class="col-md-4 col-sm-4">
                                <div class="form-group">
                                    <label>Filial</label>
                                    <select name="filial" id="filial" class="form-control">
                                        <option value="${funcionario.filial}">${funcionario.filial}</option>     
                                        <option value="${funcionario.estado}">${funcionario.estado}</option>   
                                        <option value="Selecione">Selecione</option>
                                        <option value="acre">Acre</option>
                                        <option value="alagoas">Alagoas</option>
                                        <option value="amapa">Amapá</option>
                                        <option value="bahia">Bahia</option>
                                        <option value="ceara">Ceará</option>
                                        <option value="distrito federal">Distrito Federal</option>
                                        <option value="espirito santo">Espírito Santo</option>
                                        <option value="goias">Goiás</option>
                                        <option value="maranhao">Maranhão</option>
                                        <option value="mato grosso">Mato Grosso</option>
                                        <option value="mato grosso do sul">Mato Grosso do Sul</option>
                                        <option value="minas gerais">Minas Gerais</option>
                                        <option value="para">Pará</option>
                                        <option value="paraiba">Paraíba</option>
                                        <option value="parana">Paraná</option>
                                        <option value="pernambuco">Pernambuco</option>
                                        <option value="piaui">Piauí</option>
                                        <option value="rio de janeiro">Rio de Janeiro</option>
                                        <option value="rio grande do norte">Rio Grande do Norte</option>
                                        <option value="rio grande do sul">Rio Grande do Sul</option>
                                        <option value="rondonia">Rondônia</option>
                                        <option value="roraima">Roraima</option>
                                        <option value="santa catarina">Santa Catarina</option>
                                        <option value="sao paulo">São Paulo</option>
                                        <option value="sergipe">Sergipe</option>
                                        <option value="tocantins">Tocantins</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-4">
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input name="senha" id="senha" type="password" maxlength="8" class="form-control" value="${funcionario.senha}" required placeholder="máximo 8 caracteres">
                                </div>
                            </div>
                        </div><!--Fim Linha 5.1-->  
                    </div>
                </div><!--Fim Linha 5-->

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
            </form><!--Fim do Form-->
<h1>&nbsp;</h1>
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
