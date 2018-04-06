/*
 SERVLET PRINCIPAL QUE  CHAMA AS CLASSES COM O METODO EXECUTA
 */
package controle;

import dao.RespostaDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jônatas e Wesley
 */
//servlet Principal
@WebServlet(name = "RespostaServlet", urlPatterns = {"/RespostaServlet"})
public class RespostaServlet extends HttpServlet {

    String acao, nome, cpf, senha, telefone, confSenha, email;
    int presenca, tipoLista, id;

    protected void Service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");//CODIFICAO UTF8 PARA ACENTUACAO E CARACTRES ESPECIAIS
        RespostaDao dao = new RespostaDao();

        acao = request.getParameter("acao");

        try {
            Class<?> classe = Class.forName("controle." + acao);

            ILogica logica = (ILogica) classe.newInstance();
            String jsp = logica.execute(request);

            request.getRequestDispatcher(jsp).forward(request, response);

        } catch (Exception e) {
            throw new ServletException(
                    "Houve uma falha no sistema (Servlet Principal)", e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Service(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Service(request, response);

    }
}
