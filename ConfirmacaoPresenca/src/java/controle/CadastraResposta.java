package controle;

import dao.RespostaDao;
import static java.lang.Integer.parseInt;
import javax.servlet.http.HttpServletRequest;
import modelo.Resposta;

/**
 *
 * @author Jônatas e Wesley
 */
public class CadastraResposta implements ILogica {

    public String execute(HttpServletRequest request) {
        String jsp = "";

        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String senha = request.getParameter("senha");
        String confSenha = request.getParameter("senha2");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        int presenca = parseInt(request.getParameter("presenca"));
        RespostaDao dao = new RespostaDao();

        if ((nome != null) && !(nome.isEmpty())) {
            if ((cpf != null) && !(cpf.isEmpty())) {
                if (senha.equals(confSenha)) {
                    if (presenca >= 0) {
                        if (dao.buscarCpf(cpf) != null) {
                            request.setAttribute("msg", " Ja Existe uma Resposta Cadastrada para esse CPF!");
                            jsp = "/WEB-INF/jsp/cadastroResposta.jsp";
                            return jsp;

                        } else {
                            Resposta r = new Resposta();
                            r.setCpf(cpf);
                            r.setEmail(email);
                            r.setNome(nome);
                            r.setSenha(senha);
                            r.setTelefone(telefone);
                            r.setPresenca(presenca);
                            dao.inserir(r);
                            request.setAttribute("nome", nome);
                            if (presenca == 1) {
                                request.setAttribute("presenca", "sim");
                            } else {
                                request.setAttribute("presenca", "nao");
                            }
                            jsp = "/WEB-INF/jsp/agradecimento.jsp";

                        }
                    } else {
                        request.setAttribute("msg", " confirmar presenca é obrigatorio");
                        jsp = "/WEB-INF/jsp/cadastroResposta.jsp";

                    }

                } else {
                    request.setAttribute("msg", "Senhas não são Iguais");
                    jsp = "/WEB-INF/jsp/cadastroResposta.jsp";

                }

            } else {
                request.setAttribute("msg", "O campo CPF é obrigatorio");
                jsp = "/WEB-INF/jsp/cadastroResposta.jsp";

            }

        } else {
            request.setAttribute("msg", "O campo Nome é obrigatorio");
            jsp = "/WEB-INF/jsp/cadastroResposta.jsp";

        }

        //
        return jsp;

    }

}
