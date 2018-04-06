<%-- 
    Document   : listaPresentes
    Created on : 09/11/2017, 19:09:50
    Author     : Jônatas e Wesley
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Resposta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação Presença</title>
    </head>
    <body background="imagens/festa-musica.jpg">
        <jsp:include page="menu.jsp"/>
        <br/><br/><br/>
        <c:set var = "pag" scope = "request" value = "${pag}"/>
        
        <div class="panel panel-success col-md-8 col-md-offset-2">
            <div class="panel-heading text-center"><h4>${titulo}</h4></div>
            <div class="panel-body">
                <table class="table table-hover">
                    <thead>
                        <tr class="success">
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Editar</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        
                              
                        <c:forEach items="${respostas}" var="r">

                        <tr>
                            <td>${r.getNome()}</td>
                            <td>${r.getEmail()}</td>
                            <td>${r.getTelefone()}</td>
                            <th><a href="#" class="small btn btn-warning" data-toggle="modal" 
                                   data-target="#modalSenha" 
                                   onclick="setaDadosModal('${r.getSenha()}', '${r.getNome()}',
                                                   '${r.getTelefone()}', '${r.getCpf()}', '${r.getPresenca()}', '${r.getEmail()}', '${r.getId()}')" >Editar</a></th>
                            <th><a href="RespostaServlet?acao=ExcluirResposta&id=${r.getId()}" class="small btn btn-danger">Excluir</a></th>
                        </tr>
                       </c:forEach>
                            
                    </tbody>
                </table>
            </div>
        </div>
        <br/>
        <div class="panel panel-info col-md-8 col-md-offset-2">
            <div class="text-center">
                <p class="text-danger"><strong>Ainda não confirmou sua presença?</strong></p>
                <a href="RespostaServlet?acao=PagCadastro" class="btn btn-success" >Confirme aqui</a>
            </div>
        </div>
        <!-- Modal para editar resposta, so sera aberto se o usuario digitar a resposta-->
        <div id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" class="modal fade">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header" align="center">
                        <h2 class="alert alert-info">Alteração da Resposta</h2> 
                    </div>
                    <form action="RespostaServlet" method="post">
                        <div class="row">
                            <div class="col-md-6 form-group col-md-offset-3">
                                <label for="Nome">Nome:</label>
                                <input class="form-control" type="text" id="nome" name="nome"for="Nome" required="required" />

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6 form-group col-md-offset-3">
                                <label for="Email">Email:</label>
                                <input class="form-control" name="email" id="email" placeholder="eu@hotmail.com" type="text" for="Email" required="required" />

                            </div>
                        </div>


                        <div class="row">
                            <div class="col-md-6 form-group col-md-offset-3">
                                <label for="Nome">CPF:</label>
                                <input class="form-control" type="text" name="cpf" id="cpf"
                                       for="cpf" data-mask="000.000.000-00" required="required" />

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-3 form-group col-md-offset-3">
                                <label for="senha">Senha:</label>
                                <input class="form-control" type="password" id="senha" name="senha" for="senha" />

                            </div>
                            <div class="col-md-3 form-group">
                                <label for="senha2">Confirme a Senha:</label>
                                <input class="form-control" type="password" id="senha2" name="senha2" for="senha2" />

                            </div>
                        </div>


                        <div class="row ">
                            <div class="col-md-6 form-group col-md-offset-3">
                                <label for="Telefone">Telefone:</label>
                                <input class="form-control" type="text" name="telefone" id="telefone" data-mask="0-0000-0000" required="required" />

                            </div>
                        </div>    
                        <div class="row">    
                            <div class="col-md-6 form-group col-md-offset-3">
                                <label for="Presenca">Estará presente?</label>
                                <select class="form-control"name="presenca" id="presenca" for="Presenca">
                                    <option value="-1">Escolha uma opção</option>
                                    <option value="1">Sim, eu vou!</option>
                                    <option value="0">Não, eu não poderei ir.</option>
                                </select>

                            </div>
                        </div>
                        <br/><br/>
                        <input type="hidden" id="acao" name="acao" value="AlteraResposta">
                        <input type="hidden" id="pag" name="pag" value="${pag}">
                        <input type="hidden" id="id" name="id" >
                        <div class="text-center">
                            <button class="btn btn-primary" type="submit">Confirmar Alteração</button>
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
        <!-- Modal  para receber a senha de autorizacao paar editar resposta-->
        <div class="modal fade" tabindex="-1"  id="modalSenha" role="dialog">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">

                        <h2 class="text-warning">Informe a Senha Cadastrada.</h2>
                    </div>
                    <div class="modal-body">

                        <div class="row">
                            <div class="form-group col-sm-12" text="center">
                                <label for="senha">Senha:</label>
                                <input class="form-control" type="password" id="senhadigitada" name="senhadigitada" placeholder="Informe a senha aqui!"/>
                                <input type="hidden" id="userSenha" name="userSenha" >
                            </div>

                        </div>
                        <div class="text-left">
                            <button class="btn btn-primary" 
                                    onclick="verficasenha($('#userSenha').val(), $('#senhadigitada').val())">Confirmar</button>
                        </div>

                    </div>
                    <div class="modal-footer">
                        <div align="center">
                            <span id="erro" class="alert-danger" align="left"/>
                        </div>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Fechar</button>

                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modalMsg">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">

                        <h4 class="modal-title">Confirmação Presença</h4>
                    </div>
                    <div class="modal-body">
                        <c:if test="${msg != null}">
                        <script>
                            $("#modalMsg").modal("show");
                        </script>
                        <p class="alert alert-info">${msg}</p>
                          </c:if>
                    </div>
                    <div class="modal-footer">

                        <button type="button" class="btn btn-default"  data-dismiss="modal" onclick="window.location.href = 'RespostaServlet?acao=${refresh}'" >Fechar</button>

                    </div>
                </div>
            </div>
        </div>
             

        <script>
            function setaDadosModal(senha, nome, telefone, cpf, presenca, email, id) {
                document.getElementById('userSenha').value = senha;
                document.getElementById('nome').value = nome;
                document.getElementById('telefone').value = telefone;
                document.getElementById('cpf').value = cpf;
                document.getElementById('presenca').value = presenca;
                document.getElementById('email').value = email;
                document.getElementById('senha').value = senha;
                document.getElementById('senha2').value = senha;
                document.getElementById('id').value = id;

            }
            function verficasenha(valor1, valor2) {
                if (valor2 == valor1) {
                    $('#senhadigitada').val('');
                    $('#modalSenha').modal('hide');
                    $('#modalEditar').modal('show');
                } else {
                    $('#senhadigitada').val('');
                    $('#modalSenha').modal('show');
                    $("#erro").text("Senha Incorreta. Tente Denovo!");
                }
            }
            $('#modalSenha').on('hidden.bs.modal', function () {

                $("#erro").text("");

            });


        </script>
        <script src="scrips/jquery.mask.min.js" type="text/javascript"></script>
    </body>
</html>
