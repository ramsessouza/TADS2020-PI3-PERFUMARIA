<%-- 
    Document   : erro
    Created on : 14/05/2020, 18:28:34
    Author     : Ramses
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Perfumaria Muchachos: Acesso não autorizado!</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <link href="css/unauthorized.css" rel="stylesheet">
    </head>
    
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <img id="img" src="img/unauthorized.png" alt="Logo Unauthorized">
                </div>
                <div class="col-md-9">
                    <h1 id="ops">Oops, deu ruim 401!</h1>
                </div>
            </div>
            <div class="row2">
                <div class="infos col-md-12">
                    <h2 id="titulo-mensagem">Mensagem</h2>
                    <h2 id="corpo-mensagem">Você não tem acesso a esse módulo do sistema, ou não pode executar esta ação!</h2>
                </div>
            </div>
        </div> 
    </body>
</html>
