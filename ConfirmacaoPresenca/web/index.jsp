<%-- 
    Document   : index
    Created on : 09/11/2017, 19:09:11
    Author     : Jônatas e Wesley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação Presença</title>
    </head>
    <body background="imagens/festa-musica.jpg">
        <jsp:include page="/WEB-INF/jsp/menu.jsp"/>
        <br/><br/><br/>
        <div class="col-md-8 col-md-offset-2" align="center" >
            <div class="jumbotron" >
                <h2>Churrasco Fim de Ano da Turma SI/TADS 2015</h2>
                <p>
                    Participe da confraternização de fim de ano da turma de Sistema de Informação e TADS do Salesiano.
                   <br/> Venha se divertir conosco.
                </p>
            </div>

            <div class="text-center">
                <a href="RespostaServlet?acao=PagCadastro" class="btn btn-success" >Confirme sua presença aqui</a>
            </div>
        </div>
        <script src="scrips/jquery.mask.min.js" type="text/javascript"></script>
    </body>
</html>
