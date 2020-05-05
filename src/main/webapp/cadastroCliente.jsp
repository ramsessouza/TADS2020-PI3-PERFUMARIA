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
    <!--CSS -->
    <!--Fonts Awesome-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    <!--Bootstrap-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!--Específica da Página-->
    <link href="css/start.css" rel="stylesheet">
    <link href="css/cadastroCliente.css" rel="stylesheet">
    <!--Titulo e icone-->
    <link rel="shortcut icon" href="img/logo-branco.png"/>
    <title>Perfumaria Muchachos: Cadastro de Clientes</title>
  </head>
  <body>
    <!--CABEÇALHO-->
    <div class="container-fluid">
      <div class="row cabecalho">
        <div class="col-lg-2 col-sm-2"><!--BUTTON HUMBURGER-->
          <button id="hamburger" type="button" class="btn btn-outline-dark"><span class="fas fa-bars"></span></button>
        </div>
        <div class="col-lg-3 col-sm-3"><!--LOGO CABEÇALHO-->
          <!--Colorir logo efeito em jquery - usa-se o id #logocab-->
          <img id="logocab" src="img/grupo-2.png" alt="Logo Muchachos Perfumaria">
        </div>
        <div class="col-lg-3 col-sm-3"><!--HORA E DATA-->
          <h1 id="calendario"></h><!--Data e calendario feito em jquery - usa-se o id #calendario-->
        </div>
        <div class="col-lg-2 col-sm-2"><!--USUÁRIO-->
          <h1><span class="fas fa-user"></span> Ramses Souza</h>
        </div>
        <div class="col-lg-1 col-sm-1"><!--SAIR DO SISTEMA-->
          <button type="button" class="btn btn-outline-dark" >Sair <span class="fas fa-sign-out-alt"></span></button>
        </div>
      </div>
    </div>
    <!--BARRA NAVEGACAO LATERAL-->
    <div id="barra-lateral" class="barra-lateral"><!--expandir/recolher, feito em jquery - usa o id #barra-lateral-->
      <ul><!--Colorir botões ao apertar, feito em jquery - usa a classe .item-linha-->
        <p>Vendas</p>
        <li><a class="item-linha" href="#"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
        <li><a class="item-linha" href="#"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
        <li><a class="item-linha" href="#"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
        <p>Marketing</p>
        <li><a class="item-linha" href="#"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
        <li><a class="item-linha" href="#"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
        <li><a class="item-linha" href="#"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
        <p>Tecnologia da Informação</p>
        <li><a class="item-linha" href="#"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
        <li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
        <p>Recursos Humanos</p>
        <li><a class="item-linha" href="#"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
        <p>Gerência</p>
        <li><a class="item-linha" href="#"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
        <p>Diretoria</p>
        <li><a class="item-linha" href="#"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
      </ul>
    </div>
    <!--CONTEUDO DA PAGINA-->
    <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
    <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
      <!--Formulário Geral-->
      <form class="formulario">
        <h1 class="titulo-formulario">Cadastro de Cliente</h1> 
        <!--Linha 1-->
        <div class="row linha-do-nome">
          <!--Nome-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>Nome</label>
              <input type="text" class="form-control" id="nome" placeholder="Exemplo.: Zlatan Ibrahimovic">
            </div>
          </div><!--Fim do Nome-->
          <!--Sexo-->
          <div class="col-md-2 col-sm-2">
            <div class="form-group">
              <label>Sexo</label>
              <select id="Sexo" class="form-control">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
              </select>
            </div>
          </div><!--Fim Sexo-->
          <!--Nascimento-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>Nascimento</label>
              <input type="date" class="form-control">
            </div>
          </div><!--Fim Nascimento-->
          <!--Estado Civil-->
          <div class="dropdown col-md-2 col-sm-2">
            <div class="form-group">
              <label>Estado Civil</label>
              <select id="EstadoCivil" class="form-control">
                <option value="Casado">Selecione</option>
                <option value="Casado">Casado</option>
                <option value="Solteiro">Solteiro</option>
                <option value="Divorciado">Divorciado</option>
                <option value="UniaoEstavel">União Estável</option>
              </select>
            </div>
          </div><!--Fim Estado Civil-->
          <!--Ativo-->
          <div class="col-md-2 col-sm-2">
            <div class="form-group">
              <label>Status</label>
              <select id="status" class="form-control">
                <option value="ativo">Ativo</option>
                <option value="inativo">Inativo</option>
              </select>
            </div>
          </div><!--Fim Ativo-->
        </div><!--Fim Linha 1-->

        <!--Linha 2-->
        <div class="row">
          <!--RG-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>RG</label>
              <input type="text" class="form-control" placeholder="Exemplo.: 52.498.635-9">
            </div>
          </div><!--Fim RG-->
          <!--CPF-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>CPF</label>
              <input type="text" class="form-control" placeholder="Exemplo.: 522.498.635-49">
            </div>
          </div><!--Fim CPF-->
          <!--Email-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>E-mail</label>
              <input type="e-mail" class="form-control" placeholder="Exemplo.: cliente@cliente.com">
            </div>
          </div><!--Fim Email-->
          <!--Telefone-->
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>Telefone</label>
              <input type="text" class="form-control" placeholder="Exemplo.: 11991887754">
            </div>
          </div><!--Fim Telefone-->
        </div><!--Fim Linha 2-->
          
        <!--Linha 3-->
        <div class="row">
          <!--Estado-->
          <div class="col-md-2 col-sm-2">
            <div class="form-group">
              <label>Estado</label>
              <select id="estado" class="form-control">
                <option value="acre">Selecione</option>
                <option value="acre">Acre</option>
                <option value="alagoas">Alagoas</option>
                <option value="amapá">Amapá</option>
                <option value="amazonas">Amazonas</option>
                <option value="bahia">Bahia</option>
                <option value="ceará">Ceará</option>
                <option value="distrito federal">Distrito Federal</option>
                <option value="espírito santo">Espírito Santo</option>
                <option value="goiás">Goiás</option>
                <option value="maranhão">Maranhão</option>
                <option value="mato grosso">Mato Grosso</option>
                <option value="mato grosso do sul">Mato Grosso do Sul</option>
                <option value="minas gerais">Minas Gerais</option>
                <option value="pará">Pará</option>
                <option value="paraíba">Paraíba</option>
                <option value="paraná">Paraná</option>
                <option value="pernambuco">Pernambuco</option>
                <option value="piauí">Piauí</option>
                <option value="rio de janeiro">Rio de Janeiro</option>
                <option value="rio grande do norte">Rio Grande do Norte</option>
                <option value="rio grande do sul">Rio Grande do Sul</option>
                <option value="rondônia">Rondônia</option>
                <option value="roraima">Roraima</option>
                <option value="santa catarina">Santa Catarina</option>
                <option value="são paulo">São Paulo</option>
                <option value="sergipe">Sergipe</option>
                <option value="tocantins">Tocantins</option>
              </select>
            </div>
          </div><!--Fim Estado-->
          <!--Cidade-->
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Cidade</label>
              <input type="text" class="form-control" placeholder="Exemplo.: Diadema">
            </div>
          </div><!--Fim Cidade-->
          <!--Bairro-->
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Bairro</label>
              <input type="text" class="form-control" placeholder="Exemplo.: Barueri">
            </div>
          </div><!--Fim Bairro-->
          <!--CEP-->
          <div class="col-md-2 col-sm-2">
            <div class="form-group">
              <label>Cep</label>
              <input type="text" class="form-control" placeholder="Exemplo.: 05849-890">
            </div>
          </div><!--Fim CEP-->
        </div><!--Fim Linha 3-->
        
        <!--Linha 4-->
        <div class="row">
          <!--Endereco-->
          <div class="col-md-6 col-sm-6">
            <div class="form-group">
              <label>Logradouro</label>
              <input type="text" class="form-control" placeholder="Exemplo.: Av Rubens de Oliveira">
            </div>
          </div><!--Fim Endereco-->
          <!--Numero-->
          <div class="col-md-2 col-sm-2">
            <div class="form-group">
              <label>Número</label>
              <input type="text" class="form-control" placeholder="Exemplo.: 1359">
            </div>
          </div><!--Fim Numero-->
          <!--Complemento-->
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Complemento</label>
              <input type="text" class="form-control" placeholder="Exemplo.: Torre 3">
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
              <input type="submit" value="Salvar" class="btn btn-success btn-block">
            </div><!--Fim Botão Salvar-->
          </div><!--Fim Linha 5-->
        </div><!--Fim classe botoes-->
      </form><!--Fim do Form-->
    </div><!--Fim do conteudo da pagina-->
    
    <!--1-jQuery.js-->
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
      <!--2-Popper.js-->
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
      <!--3-Bootstrap.js -->
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
      <script type="text/javascript" src="js/start.js"></script>
  </body>
</html>
