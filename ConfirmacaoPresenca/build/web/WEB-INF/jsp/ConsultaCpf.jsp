<%-- 
    Document   : ConsultaCpf
    Created on : 15/11/2017, 18:42:27
    Author     : Jônatas e Wesley
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form class="navbar-form navbar-left" action="RespostaServlet" method="Get">
            <div class="form-group">
                <input type="text" class="form-control cpf" name="cpfDigitado" id="cpfDigitado"
                       placeholder="Buscar Por Cpf" data-mask="000.000.000-00" ></input>

            </div>
            <input type="hidden" id="acao" name="acao" value="ListarPorCpf">
            <button type="submit" class="btn btn-default">Pesquisar</button>
        </form>
       
    </body>




</html>
