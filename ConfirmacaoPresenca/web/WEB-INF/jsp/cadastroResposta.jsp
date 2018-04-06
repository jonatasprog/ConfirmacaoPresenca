<%-- 
    Document   : cadastroResposta
    Created on : 09/11/2017, 19:10:16
    Author     : Jônatas e Wesley
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação Presença</title>
    </head>
    <body background="imagens/festa-musica.jpg">
        <jsp:include page="menu.jsp"/>
        <div class="panel panel-success col-md-8 col-md-offset-2">
            <div class="panel-heading text-center "><h4>Formulário de confirmação de presença</h4></div>
            <div class="panel-body">
                <form action="RespostaServlet" method="post">
                    <div class="row">
                        <div class="col-md-6 form-group col-md-offset-3">
                            <label for="Nome">Nome:</label>
                            <input class="form-control" type="text" name="nome"for="Nome" required="required" />

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 form-group col-md-offset-3">
                            <label for="Email">Email:</label>
                            <input class="form-control" name="email" placeholder="eu@hotmail.com" type="text" for="Email" required="required" />

                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6 form-group col-md-offset-3">
                            <label for="Nome">CPF:</label>
                            <input class="form-control" type="text" name="cpf"
                                   for="cpf" data-mask="000.000.000-00" required="required" />

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3 form-group col-md-offset-3">
                            <label for="senha">Senha:</label>
                            <input class="form-control" type="password" name="senha" for="senha" />

                        </div>
                        <div class="col-md-3 form-group">
                            <label for="senha2">Confirme a Senha:</label>
                            <input class="form-control" type="password" name="senha2" for="senha2" />

                        </div>
                    </div>
            </div>

            <div class="row ">
                <div class="col-md-6 form-group col-md-offset-3">
                    <label for="Telefone">Telefone:</label>
                    <input class="form-control" type="text" name="telefone" data-mask="0-0000-0000" required="required" />

                </div>
            </div>    
            <div class="row">    
                <div class="col-md-6 form-group col-md-offset-3">
                    <label for="Presenca">Estará presente?</label>
                    <select class="form-control"name="presenca" for="Presenca">
                        <option value="-1">Escolha uma opção</option>
                        <option value="1">Sim, eu vou!</option>
                        <option value="0">Não, eu não poderei ir.</option>
                    </select>

                </div>
            </div>
            <input type="hidden" id="acao" name="acao" value="CadastraResposta">

            <div class="text-center">
                <button class="btn btn-primary" type="submit">Confirmar</button>
            </div>
        </form>
    </div>
</div>

<div class="modal fade" id="modalerro">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span>×</span></button>
                <h4 class="modal-title">Confirmação Presença</h4>
            </div>
            <div class="modal-body">
                <c:if test="${msg != null}">
                <script>
                    $("#modalerro").modal("show");
                </script>
                <p class="alert alert-info">${msg}</p>
                </c:if>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>

            </div>
        </div>
    </div>
</div>
<br/><br/><br/>
<script src="scrips/jquery.mask.min.js" type="text/javascript"></script>

</body>
</html>
