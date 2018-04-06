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
public class ListarTodos implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";
      
        RespostaDao dao = new RespostaDao();
        List<Resposta> respostas = dao.buscarTodos();
        request.setAttribute("titulo", "Lista de Todas de Respostas");
         request.setAttribute("pag", "1");
            request.setAttribute("refresh", "ListarTodos");
        request.setAttribute("respostas", respostas);

        jsp = "/WEB-INF/jsp/listaPresentes.jsp";
        return jsp;

    }

}
