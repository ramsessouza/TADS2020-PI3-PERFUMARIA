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
          <h1><span class="fas fa-user"></span>Valter Lafuente</h>
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
                <li><a class="item-linha" href="venda.jsp"><span class="fas fa-shopping-cart mr-4"></span> Venda</a></li>
                <li><a class="item-linha" href="cadastroCliente.jsp"><span class="fas fa-user-plus mr-4"></span>Cadastro de Cliente</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-4"></span>Consulta de Cliente</a></li>
                <p>Marketing</p>
                <li><a class="item-linha" href="cadastroProduto.jsp"><span class="fas fa-pump-soap mr-4"></span> Cadastro de Produto</a></li>
                <li><a class="item-linha" href="consultaProdutoServlet"><span class="fas fa-search mr-4"></span>Consulta de Produto</a></li>
                <li><a class="item-linha" href="consultaCliente.jsp"><span class="fas fa-users mr-3"></span> Consulta de Cliente</a></li>
                <p>Tecnologia da Informação</p>
                <li><a class="item-linha" href="cadastroFuncionario.jsp"><span class="fas fa-user-tie mr-4"></span> Cadastro de Colaborador</a></li>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Recursos Humanos</p>
                <li><a class="item-linha" href="consultaFuncionarioServlet"><span class="fas fa-user-edit mr-3"></span> Consulta de Colaborador</a></li>
                <p>Gerência</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-line mr-3"></span> Relatório Filial</a></li>
                <p>Diretoria</p>
                <li><a class="item-linha" href="relatorios.jsp"><span class="fas fa-chart-bar mr-3"></span> Relatório Geral</a></li>
            </ul>
        </div>
    <!--CONTEUDO DA PAGINA-->
    <!--expandir/recolher, feito em jquery - usa o id #conteudo-pagina-->
    <div id="conteudo-pagina" class="container-fluid conteudo-pagina">
      <!--Formulário Geral-->
      <form id="formulario" class="formulario" action="funcionarioServlet" method="post">
                <h1 class="titulo-formulario">Editar Colaborador: ${funcionario.nome}</h1> 
        <!--Linha 1-->
        <div class="row linha-do-nome">
            
          <div class="col-md-11 col-sm-11">
             <input type="hidden" name="id"  value="${funcionario.id}">
          </div>
          
          <div class="col-md-9 col-sm-9">
            <div class="form-group">
              <label>Nome</label>
              <input type="text" class="form-control" name="nome" value="${funcionario.nome}" id="nome" required >
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
          <div class="col-md-3 col-sm-3">
            <div class="form-group">
              <label>Nascimento</label>
              <input name="dataNascimento" id="dataNascimento" type="date" class="form-control" value="${funcionario.dataNascimento}" required >
            </div>
          </div>
          <div class="col-md-9 col-sm-9">
            <!--Linha 2.1-->
            <div class="row">
              <div class="col-md-3 col-sm-3">
                <div class="form-group">
                  <label>RG</label>
                  <input name="rg" id="rg" type="text" class="form-control" value="${funcionario.rg}" placeholder="##.###.###-#" >
                </div>
              </div>
              <div class="col-md-3 col-sm-3">
                <div class="form-group">
                  <label>CPF</label>
                  <input name="cpf" id="cpf" type="text" class="form-control" value="${funcionario.cpf}" required  placeholder="###.###.###-##">
                </div>
              </div>
              <div class="dropdown col-md-3 col-sm-3">
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
              <div class="col-md-3 col-sm-3">
                <div class="form-group">
                  <label>Sexo</label>
                  <select name="sexo" id="sexo" class="form-control">
                    <option value="${funcionario.sexo}">${funcionario.sexo}</option>     
                    <option value="Masculino">Masculino</option>
                    <option value="Feminino">Feminino</option>
                  </select>
                </div>
              </div>
            </div><!--Fim Linha 2.1-->
          </div>
        </div><!--Fim Linha 2-->
          
        <!--Linha 3-->
        <div class="row">
          <div class="col-md-8 col-sm-8">
            <div class="form-group">
              <label>Endereço</label>
              <input name="logradouro" id="logradouro" type="text" class="form-control" value="${funcionario.logradouro}" required>
            </div>
          </div>
          <div class="col-md-4 col-sm-2">
            <div class="form-group">
              <label>Número</label>
              <input name="numero" id="numero" type="text" class="form-control" value="${funcionario.numero}" required>
            </div>
          </div>  
        </div><!--Fim Linha 3-->
          
        <!--Linha 4-->
        <div class="row">
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Bairro</label>
              <input name="bairro" id="bairro" type="text" class="form-control" value="${funcionario.bairro}">
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Cidade</label>
              <input name="cidade" id="cidade" type="text" class="form-control" value="${funcionario.cidade}" required>
            </div>
          </div>
          <div class="col-md-4 col-sm-4">
            <div class="form-group">
              <label>Complemento</label>
              <input name="complemento" id="complemento" type="text" class="form-control" value="${funcionario.complemento}">
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
                 <option value="Selecione">Selecione</option>
                 <option value="acre">Acre</option>
                 <option value="alagoas">Alagoas</option>
                 <option value="amapá">Amapá</option>
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
          <div class="col-md-9 col-sm-9">
            <!--Linha 5.1-->
            <div class="row">
              <div class="col-md-6 col-sm-4">
                <div class="form-group">
                  <label>Telefone</label>
                  <input name="telefone" id="telefone" type="text" class="form-control" value="${funcionario.telefone}" required placeholder="(**)*****-****" >
                </div>
              </div> 
              <div class="col-md-6 col-sm-4">
                <div class="form-group">
                  <label>E-mail</label>
                  <input name="email" id="email" type="E-mail" class="form-control" value="${funcionario.email}" required>
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
                    <option value="Publicidade">Publicidade</option>
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
                    <option value="Venda">Venda</option>
                    <option value="Marketing">Marketing</option>
                    <option value="Publicidade">Publicidade</option>
                    <option value="TI">TI</option>
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
                 <option value="amapá">Amapá</option>
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
              </div>
              <div class="col-md-4 col-sm-4">
                <div class="form-group">
                  <label>Senha</label>
                  <input name="senha" id="senha" type="password" class="form-control" value="${funcionario.senha}"required>
                </div>
              </div>
            </div><!--Fim Linha 5.1-->  
          </div>
        </div><!--Fim Linha 5-->
              
        <!--Linha 6-->
       <div class="botoes">
	 <div class="row">
          <div class=" offset-md-8 col-sm-2">
            <!--Botão Limpar-->
	    <input type="reset" value="Limpar" class="btn btn btn-danger btn-block">						
	     </div>
	    <div class="col-sm-2">
	 <!--Botão Salvar-->
	    <input type="submit" value="Atualizar" class="btn btn-success btn-block">
  	   </div>
	 </div><!--Fim da linha 4-->
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
