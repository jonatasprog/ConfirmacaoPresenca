/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.RespostaDao;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class ListarConfirmados implements ILogica {
    
    public String execute(HttpServletRequest request) {
        String jsp = "";
        int tipoLista = 2;
        RespostaDao dao = new RespostaDao();
            List<Resposta> respostas = dao.buscarConfirmados();
            request.setAttribute("titulo", "Lista de Presenças Confirmadas");
            request.setAttribute("pag", "2");
            request.setAttribute("refresh", "ListarConfirmados");
            request.setAttribute("respostas", respostas);
            jsp = "/WEB-INF/jsp/listaPresentes.jsp";
    
            return jsp;
    }
}
