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
        <title>Perfumaria Muchachos: Error Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <style> 
                @font-face {font-family: 'FuturaLight';	src: url("fonts/FuturaPTLight.otf");}
                @font-face {font-family: 'FuturaBold';	src: url("fonts/FuturaPTBold.otf");}
                body{padding-top: 30px; background-color: rgba(244,128,41,0.8); align-items: center; text-align: center; font-family: FuturaBold;}
                img{max-width:90%; height:auto;}
                #ops{font-size: 90px}
                .row{align-items: center}
                .infos{margin-top: 20px; margin-left: 30px; text-align: left}
                .infos h2{font-size: 40px}
                .infos span{font-size: 40px; font-family: FuturaLight}
        </style>
    </head>
    
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <img id="img" src="img/error.png" alt="Logo Error">
                </div>
                <div class="col-md-9">
                    <h1 id="ops">Oops, deu ruim ${requestScope['javax.servlet.error.status_code']} !</h1>
                </div>
            </div>
            <div class="row">
                <div class="infos col-md-10">
                    <h2>Type: <span>${requestScope['javax.servlet.error.message']}</span></h2>
                    <h2>Local: <span>${requestScope['javax.servlet.error.request_uri']}</span></h2>
                    <h2>Servelet: <span>${requestScope['javax.servlet.error.servlet_name']}</span></h2>
                    <h2>Mensagem: <span>${mensagemErro}</span></h2>
                </div>
            </div>
        </div> 
    </body>
</html>
