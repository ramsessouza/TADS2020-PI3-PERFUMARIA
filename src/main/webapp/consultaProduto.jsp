<%-- 
    Document   : cadastroProduto
    Created on : 01/05/2020, 18:42:36
    Author     : Diego Souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
  <head>
       <meta charset="utf-8">
       <link rel="stylesheet" href="css/tabela.css">
       <link rel="shortcut icon" href="imagem/muchachos.png">
       <link rel="stylesheet" href="css/estilobootstrap.css">
       <link rel="stylesheet" href="css/base.css">
       <link rel="stylesheet" href="css/layout.css">
       <link rel="stylesheet" href="css/cadastroProduto.css">
       <!-- Latest compiled and minified CSS -->
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  </head>

  <body>

     <header class="layout-cabecalho layout-cabecalho--tabela">
      <div class="container">
        <nav class="navegacao">
          <a href="index.html"><img src="img/muchachos.png" width="60" height="60" alt="Muchachos" /></a>
        </nav> 
      </div>
    </header>




     <div class="container">
       <h1 class="titulo-formulario">Gerenciamento de Produto</h1>
          <form>    
            <div class="row">
              <div class="col-sm-5">
             <div class="grupo-entrada">
           <input placeholder="Digite o nome ou código produto do aqui " type="text" class="campo" required>
        </div>
      </div>

       <div class="col-sm-3">
       <div class="grupo-entrada">
            <div style="text-align: center; margin-top: 20px">
              <input type="submit" value="Buscar" class="botao-tabela">
            </div>
         </div> 
        </div>
      </div>         
        </div> 
         </form>
      </div>

      <table class="tabela">     
       <thead>
        <tr>
          <th>Código</th>
          <th>Produto</th>
          <th>Quantidade</th>
          <th>Categoria</th>
          <th>Valor</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
    </table>


       <footer class="layout-rodape">
      <div class="container">
        <p>&copy; Muchachos. Todos os direitos reservados.</p>
      </div>
    </footer>
     </body>
</html>