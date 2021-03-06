<%-- 
    Document   : cadastroCliente
    Created on : 01/05/2020, 15:10:31
    Author     : Otávio Barros
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
        <title>Perfumaria Muchachos: Cadastro de Clientes</title>
    </head>
    <body>
        <!--IMPORT DO CABECALHO E DA BARRA LATERAL-->
        <%@ include file="main.jsp" %> 
        <!--CONTEUDO DA PAGINA-->
        <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
        <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
            <!--Formulário Geral-->
            <form id="formulario" class="formulario" >
                <h1 class="titulo-formulario">Cadastro de Cliente</h1> 
                <!--Linha 1-->
                <div class="row linha-do-nome">
                    <!--Nome-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>Nome</label>
                            <input id="nome" type="text" class="form-control" maxlength="30" placeholder="Exemplo.: Zlatan Ibrahimovic" required="">
                        </div>
                    </div><!--Fim do Nome-->
                    <!--Sexo-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Sexo</label>
                            <select id="sexo" class="form-control">
                                <option value="Masculino">Masculino</option>
                                <option value="Feminino">Feminino</option>
                            </select>
                        </div>
                    </div><!--Fim Sexo-->
                    <!--Nascimento-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>Nascimento</label>
                            <input id="dataNascimento" type="date" class="form-control" placeholder="MM/DD/AAAA" required>
                        </div>
                    </div><!--Fim Nascimento-->
                    <!--Estado Civil-->
                    <div class="dropdown col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Estado Civil</label>
                            <select id="estadoCivil" class="form-control">
                                <option value="Casado">Casado</option>
                                <option value="Solteiro">Solteiro</option>
                                <option value="Divorciado">Divorciado</option>
                                <option value="União Estável">União Estável</option>
                            </select>
                        </div>
                    </div><!--Fim Estado Civil-->
                    <!--Status-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Status</label>
                            <select id="status" class="form-control">
                                <option value="Ativo">Ativo</option>
                                <option value="Inativo">Inativo</option>
                            </select>
                        </div>
                    </div><!--Fim Status-->
                </div><!--Fim Linha 1-->
                <!--Linha 2-->
                <div class="row">
                    <!--RG-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>RG</label>
                            <input id="rg" type="text" class="form-control" maxlength="15" pattern="[a-zA-Z0-9-]+" placeholder="Apenas numeros e letra">
                        </div>
                    </div><!--Fim RG-->
                    <!--CPF-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <div class="form-inline inline-cpf">
                                <label>CPF</label>
                                <label id="mensagem-cpf"></label>
                            </div>
                            <input id="cpf" class="form-control mascara-cpf cpf-cliente" placeholder="Exemplo.: 522.498.635-49" required>
                        </div>
                    </div><!--Fim CPF-->
                    <!--Email-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>E-mail</label>
                            <input id="email" type="email" class="form-control" placeholder="Exemplo.: cliente@cliente.com" required>
                        </div>
                    </div><!--Fim Email-->
                    <!--Telefone-->
                    <div class="col-md-3 col-sm-3">
                        <div class="form-group">
                            <label>Telefone</label>
                            <input id="telefone" type="text" class="form-control mascara-telefone" placeholder="Exemplo.: 11991887754" required>
                        </div>
                    </div><!--Fim Telefone-->
                </div><!--Fim Linha 2-->

                <!--Linha 3-->
                <div class="row">
                    <!--Estado-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Estado</label>
                            <select id="estado" class="form-control" required>
                                <option value="São Paulo">São Paulo</option>
                                <option value="Acre">Acre</option>
                                <option value="Alagoas">Alagoas</option>
                                <option value="Amapá">Amapá</option>
                                <option value="Amazonas">Amazonas</option>
                                <option value="Bahia">Bahia</option>
                                <option value="Ceará">Ceará</option>
                                <option value="Distrito Federal">Distrito Federal</option>
                                <option value="Espírito Santo">Espírito Santo</option>
                                <option value="Goiás">Goiás</option>
                                <option value="Maranhão">Maranhão</option>
                                <option value="Mato Grosso">Mato Grosso</option>
                                <option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
                                <option value="Minas Gerais">Minas Gerais</option>
                                <option value="Pará">Pará</option>
                                <option value="Paraíba">Paraíba</option>
                                <option value="Paraná">Paraná</option>
                                <option value="Pernambuco">Pernambuco</option>
                                <option value="Piauí">Piauí</option>
                                <option value="Rio de Janeiro">Rio de Janeiro</option>
                                <option value="Rio Grande do Norte">Rio Grande do Norte</option>
                                <option value="Rio Grande do Sul">Rio Grande do Sul</option>
                                <option value="Rondônia">Rondônia</option>
                                <option value="Roraima">Roraima</option>
                                <option value="Santa Catarina">Santa Catarina</option>
                                <option value="Sergipe">Sergipe</option>
                                <option value="Tocantins">Tocantins</option>
                            </select>
                        </div>
                    </div><!--Fim Estado-->
                    <!--Cidade-->
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Cidade</label>
                            <input id="cidade" type="text" class="form-control" maxlength="40" placeholder="Exemplo.: Diadema">
                        </div>
                    </div><!--Fim Cidade-->
                    <!--Bairro-->
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Bairro</label>
                            <input id="bairro" type="text" class="form-control" maxlength="40" placeholder="Exemplo.: Barueri">
                        </div>
                    </div><!--Fim Bairro-->
                    <!--CEP-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Cep</label>
                            <input id="cep" type="text" class="form-control mascara-cep" placeholder="Exemplo.: 05849-890">
                        </div>
                    </div><!--Fim CEP-->
                </div><!--Fim Linha 3-->

                <!--Linha 4-->
                <div class="row">
                    <!--Endereco-->
                    <div class="col-md-6 col-sm-6">
                        <div class="form-group">
                            <label>Logradouro</label>
                            <input id="logradouro" type="text" class="form-control" maxlength="50" placeholder="Exemplo.: Av Rubens de Oliveira" required>
                        </div>
                    </div><!--Fim Endereco-->
                    <!--Numero-->
                    <div class="col-md-2 col-sm-2">
                        <div class="form-group">
                            <label>Número</label>
                            <input id="numero" type="number" class="form-control mascara-numero" maxlength="6" placeholder="Exemplo.: 1359" required>
                        </div>
                    </div><!--Fim Numero-->
                    <!--Complemento-->
                    <div class="col-md-4 col-sm-4">
                        <div class="form-group">
                            <label>Complemento</label>
                            <input id="complemento" type="text" class="form-control" maxlength="20" placeholder="Exemplo.: Torre 3">
                        </div>
                    </div><!--Fim Complemento-->
                </div><!--Fim Linha 4-->

                <!--Linha 5-->
                <div class="botoes">
                    <div class="row">
                        <!--Botão Limpar-->
                        <div class=" offset-md-8 col-sm-2">
                            <input type="reset" value="Limpar" class="btn btn btn-danger btn-block">            
                        </div><!--Fim Botão Limpar-->
                        <!--Botão Salvar-->
                        <div class="col-sm-2">
                            <input id="btn-salvar" type="submit" value="Salvar" class="btn btn-success btn-block">
                        </div><!--Fim Botão Salvar-->
                    </div><!--Fim Linha 5-->
                </div><!--Fim classe botoes-->
            </form><!--Fim do Form-->
        </div><!--Fim do conteudo da pagina-->
        
        <!--MODAL CADASTRO-->
        <div class="modal fade modal" id="modalMensagem" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Mensagem</h5>
                        <button type="button" class="close fechar-modal"><!--data-dismiss="modal"-->
                            <span class="fas fa-times"></span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>O Cliente <span id="mensagem"></span> foi salvo com sucesso!</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger btn-sm fechar-modal"><!--data-dismiss="modal"-->
                            <span class="fas fa-times mr-2"></span>Fechar
                        </button>
                    </div>
                </div>
            </div>
        </div>
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
        <script type="text/javascript" src="js/cadastroCliente.js"></script>
        <script type="text/javascript" src="js/validacao.js"></script>
    </body>
</html>
