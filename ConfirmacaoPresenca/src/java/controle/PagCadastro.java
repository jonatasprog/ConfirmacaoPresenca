/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jônatas e Wesley
 */
public class PagCadastro implements ILogica {
     public String execute(HttpServletRequest request) {
        
        return "/WEB-INF/jsp/cadastroResposta.jsp";
     }
    
    
    
}
