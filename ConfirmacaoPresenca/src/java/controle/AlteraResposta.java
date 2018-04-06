/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RespostaDao;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class AlteraResposta implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";
        int id = parseInt(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String confSenha = request.getParameter("senha2");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        int presenca = parseInt(request.getParameter("presenca"));
        RespostaDao dao = new RespostaDao();
        String pag = request.getParameter("pag");
        List<Resposta> respostas = null;
        String titulo = null;
        String refresh = null;
        if(pag.equals("1"))request.setAttribute("refresh", "ListarTodos");
        if(pag.equals("2"))request.setAttribute("refresh", "ListarConfirmados");
        if(pag.equals("3"))request.setAttribute("refresh", "ListarNaoConfirmados");
        id = parseInt(request.getParameter("id"));
        if ((nome != null) && !(nome.isEmpty())) {
            
            if ((cpf != null) && !(cpf.isEmpty())) {
                if (senha.equals(confSenha)) {
                    if (presenca >= 0) {

                        Resposta r = new Resposta();
                        r.setId(id);
                        r.setCpf(cpf);
                        r.setEmail(email);
                        r.setNome(nome);
                        r.setSenha(senha);
                        r.setTelefone(telefone);
                        r.setPresenca(presenca);
                        dao.alterar(r);
                       // request.setAttribute("refresh", "ListarTodos");
                        request.setAttribute("msg", "Registro Alterado com sucesso.");
                        request.setAttribute("titulo", titulo);
                        request.setAttribute("respostas", respostas);

                    } else {
                       // request.setAttribute("refresh", "ListarTodos");
                        request.setAttribute("titulo", titulo);
                        request.setAttribute("msg", "confirmar presenca é obrigatorio");
                        request.setAttribute("respostas", respostas);

                    }

                } else {
                  //  request.setAttribute("refresh", "ListarTodos");
                    request.setAttribute("msg", "Senhas não são Iguais");
                    request.setAttribute("respostas", respostas);

                }

            } else {
             //   request.setAttribute("refresh", "ListarTodos");
                request.setAttribute("msg", "O campo CPF é obrigatorio");
                request.setAttribute("respostas", respostas);

            }

        } else {
          //  request.setAttribute("refresh", "ListarTodos");
            request.setAttribute("msg", "O campo Nome é obrigatorio");
            request.setAttribute("respostas", respostas);

        }
        jsp = "/WEB-INF/jsp/listaPresentes.jsp";
        return jsp;

    }
}
