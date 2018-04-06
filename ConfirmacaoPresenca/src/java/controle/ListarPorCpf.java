/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RespostaDao;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class ListarPorCpf implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";

        RespostaDao dao = new RespostaDao();
        String cpf = request.getParameter("cpfDigitado");
        List<Resposta> respostas = new ArrayList();
        Resposta r = (Resposta) dao.buscarCpf(cpf);
        request.setAttribute("titulo", "Minha Resposta");
        request.setAttribute("pag", "4");
        if (r != null) {
            respostas.add(r);
            request.setAttribute("pag", "1");
            request.setAttribute("refresh", "ListarTodos");
            request.setAttribute("respostas", respostas);
            jsp = "/WEB-INF/jsp/listaPresentes.jsp";
            return jsp;
        } else {

            request.setAttribute("pag", "1");
            request.setAttribute("msg", "Você ainda não Respondeu");
            request.setAttribute("refresh", "ListarTodos");

            request.setAttribute("respostas", respostas);
            jsp = "/WEB-INF/jsp/listaPresentes.jsp";
            return jsp;
        }

    }

}
