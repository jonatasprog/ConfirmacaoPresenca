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
public class ExcluirResposta implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";

        int id = parseInt(request.getParameter("id"));
        RespostaDao dao = new RespostaDao();
        Resposta r = new Resposta();

        r.setId(id);
        try {
            dao.excluir(r);
            List<Resposta> respostas = dao.buscarTodos();
            request.setAttribute("titulo", "Todas as Respostas");
            request.setAttribute("refresh", "ListarTodos");
            request.setAttribute("respostas", respostas);
            jsp = "/WEB-INF/jsp/listaPresentes.jsp";

        } catch (Exception ex) {
            request.setAttribute("msg", "A Resposta Não foi Removida!");
            request.setAttribute("refresh", "ListarTodos");
            jsp = "/WEB-INF/jsp/listaPresentes.jsp";
        }

        return jsp;
    }

}
