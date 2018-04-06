<%-- 
    Document   : menu
    Created on : 09/11/2017, 19:11:55
    Author     : Jônatas e Wesley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="scrips/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="scrips/site.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmacao Presença</title>
    </head>
    <body>
        <div class="container col-md-8 col-md-offset-2">
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a href="index.jsp" class="navbar-brand" >Início</a>
                    </div>
                    <ul class="nav navbar-nav">
                        <li><a href="RespostaServlet?acao=PagCadastro">Confirmação</a></li>
                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#">Respostas
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="RespostaServlet?acao=ListarTodos">Todas Respostas</a></li>
                                <li><a href="RespostaServlet?acao=ListarConfirmados">Lista Confirmados</a></li>
                                <li><a href="RespostaServlet?acao=ListarNaoConfirmados">Lista não Confirmados</a></li>
                            </ul>
                        </li>
                        <li><a href="RespostaServlet?acao=PagSobre">Sobre</a></li>
                         <li><jsp:include page="/WEB-INF/jsp/ConsultaCpf.jsp"/></li>
                    </ul>
                </div>
            </nav>
        </div>
        <script src="scrips/jquery.min.js" type="text/javascript"></script>
        <script src="scrips/bootstrap.min.js" type="text/javascript"></script>

    </body>
</html>
