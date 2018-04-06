<%-- 
    Document   : agradecimento
    Created on : 10/11/2017, 10:32:07
    Author     : Jônatas e Wesley
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        title>Confirmação Presença</title>
</head>
<body background="imagens/festa-musica.jpg">
    <jsp:include page="menu.jsp"/>
    <br/><br/><br/>
    <div class="col-md-8 col-md-offset-2" align="center">
        <div class="jumbotron">
            <h2>Obrigado, ${param.nome}</h2>
            <div>
                <c:if test="${param.presenca == 1}">

                    <p>Que bom irá participar. Contamos com você!</p>
                    <div class="text-center">
                        <a href="RespostaServlet?acao=ListarConfirmados" class="btn btn-success" >Confira quem também irá participar!</a>
                    </div>
                </c:if>
                <c:if test="${param.presenca == 0}">
                    <p>Que pena que não poderá participar, mas obrigado por nos avisar!</p>
                </c:if>
            </div>
        </div>
    </div>
    <script src="scrips/jquery.mask.min.js" type="text/javascript"></script>
</body>
</html>
