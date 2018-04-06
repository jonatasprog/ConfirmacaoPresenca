/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RespostaDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class ListarNaoConfirmados implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";
      
        RespostaDao dao = new RespostaDao();
        List<Resposta> respostas = dao.buscarNaoConfirmados();
        request.setAttribute("titulo", "Lista quem não Irá Participar");
        request.setAttribute("pag", "3");
            request.setAttribute("refresh", "ListarNaoConfirmados");
        request.setAttribute("respostas", respostas);

        jsp = "/WEB-INF/jsp/listaPresentes.jsp";
        return jsp;

    }

}
